package effectivejava.chapter4.item20.java8;

/**
 * Car
 *
 * @author huangfl
 * @since 2018/8/13
 */
class Car implements Vehicle, FourWheeler {

    @Override
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
}