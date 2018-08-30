package effectivejava.chapter6.item34;

/**
 * The strategy enum pattern -- 策略枚举
 */
public enum PayrollDay {
    // 周一~周日
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        // 周末按照(PayType.WEEKEND)计算
        this.payType = payType;
    }

    PayrollDay() {
        // 默认按照工作日(PayType.WEEKDAY)计
        this(PayType.WEEKDAY);
    }

    double pay(double minutesWorked, double payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    // The strategy enum type
    private enum PayType {
        // 工作日超时8小时算加班
        WEEKDAY {
            @Override
            double overtimePay(double minsWorked, double payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                        (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        // 周末都算加班
        WEEKEND {
            @Override
            double overtimePay(double minsWorked, double payRate) {
                // 加班按1.5倍
                return minsWorked * payRate / 2;
            }
        };

        abstract double overtimePay(double mins, double payRate);

        // 正常工作8小时
        private static final double MINS_PER_SHIFT = 8;

        double pay(double minsWorked, double payRate) {
            double basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

    public static void main(String[] args) {
        double payMonday = PayrollDay.MONDAY.pay(9, 1);
        System.out.println(payMonday);

        double paySaturday = PayrollDay.SATURDAY.pay(9, 1);
        System.out.println(paySaturday);
    }
}
