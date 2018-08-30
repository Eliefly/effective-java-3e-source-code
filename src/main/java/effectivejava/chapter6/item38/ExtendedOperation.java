package effectivejava.chapter6.item38;

// Emulated extension enum - (Pages 175-7)
public enum ExtendedOperation implements Operation {
    //
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };
    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // WRITE DESCR ***
    public static void main(String[] args) {

        args = new String[]{"1.2", "3.4"};

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(ExtendedOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }

    // WRITE DESCR ***
//    public static void main(String[] args) {
//        double x = Double.parseDouble(args[0]);
//        double y = Double.parseDouble(args[1]);
//        test(Arrays.asList(ExtendedOperation.values()), x, y);
//    }
//
//    private static void test(Collection<? extends Operation> opSet,
//                             double x, double y) {
//        for (Operation op : opSet) {
//            System.out.printf("%f %s %f = %f%n",
//                    x, op, y, op.apply(x, y));
//        }
//    }
}
