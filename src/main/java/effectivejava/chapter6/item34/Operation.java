package effectivejava.chapter6.item34;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Enum type with constant-specific class bodies and data  (Page 161)
public enum Operation {
    // 加
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    // 减
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    // 乘
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    // 除
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    /**
     * 枚举的构造方法，这样传入的symbol就和枚举常量关联了
     */
    Operation(String symbol) {
        this.symbol = symbol;
    }

    /**
     * 覆盖toString方法
     */
    @Override
    public String toString() {
        return symbol;
    }

    /**
     * 抽象方法，新加入的枚举常量一定要实现该抽象方法，防止遗漏。
     */
    public abstract double apply(double x, double y);

    // Implementing a fromString method on an enum type
//    private static final Map<String, Operation> stringToEnum =
//            Stream.of(values()).collect(
//                    toMap(Object::toString, e -> e));

    private static final Map<String, Operation> stringToEnum = new HashMap<>();

    static {
        for (Operation op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    // Returns Operation for string, if any
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {

        args = new String[]{"2.2", "2.8"};

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }

        Operation operation = Operation.stringToEnum.get("+");
        System.out.println(operation);
    }
}
