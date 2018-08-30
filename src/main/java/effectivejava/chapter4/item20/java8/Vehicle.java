package effectivejava.chapter4.item20.java8;

/**
 * Vehicle
 *
 * @author huangfl
 * @since 2018/8/13
 */
public interface Vehicle {

    /**
     * jdk1.8 接口引入了默认方法，使用default修饰。
     */
    default void print() {
        System.out.println("我是一辆车!");
    }

    /**
     * 默认的静态方法
     */
    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }
}