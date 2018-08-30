package effectivejava.chapter4.item20.java8;

/**
 * FourWheeler
 *
 * @author huangfl
 * @since 2018/8/13
 */
interface FourWheeler {
    default void print() {
        System.out.println("我是一辆四轮车!");
    }
}