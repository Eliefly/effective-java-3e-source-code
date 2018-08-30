package effectivejava.chapter5.item33.mytest;

/**
 * TestMain
 *
 * @author huangfl
 * @since 2018/8/18
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("effectivejava.chapter5.item33.mytest.MyClassA");
        Class<?> aAnnotation = Class.forName("effectivejava.chapter5.item33.mytest.MyAnnotation");
        MyAnnotation myAnnotation = aClass.getAnnotation(MyAnnotation.class);

        System.out.println(myAnnotation.module());
        System.out.println(myAnnotation.value());
    }
}
