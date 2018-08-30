package effectivejava.chapter5.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

// Use of asSubclass to safely cast to a bounded type token - Page 146
public class PrintAnnotation {
    // Use of asSubclass to safely cast to a bounded type token
    static Annotation getAnnotation(AnnotatedElement element,
                                    String annotationTypeName) {
        Class<?> annotationType = null; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(
                annotationType.asSubclass(Annotation.class));
    }

    // Test program to print named annotation of named class
    public static void main(String[] args) throws Exception {

        args = new String[]{"effectivejava.chapter5.item33.mytest.MyClassA",
                "effectivejava.chapter5.item33.mytest.MyAnnotation"};

        if (args.length != 2) {
            System.out.println(
                    "Usage: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        Class<?> klass = Class.forName(args[0]);
        String annotationTypeName = args[1];
        Annotation annotation = getAnnotation(klass, annotationTypeName);
        System.out.println(annotation.toString());
    }
}
