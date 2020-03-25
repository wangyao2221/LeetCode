package Test.annotationTest;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Integer i = 0;
        Integer j = i;
        j = 1;
        System.out.println(System.identityHashCode(i));
        System.out.println(System.identityHashCode(j));
        try {
            Class studentClass = Class.forName("Test.annotationTest.Student");
            Method studyMethod = studentClass.getMethod("study", int.class);

            if (studyMethod.isAnnotationPresent(CherryAnnotation.class)) {
                System.out.println("Student CherryAnnotation yes");
                CherryAnnotation cherryAnnotation = studyMethod.getAnnotation(CherryAnnotation.class);
                System.out.println(cherryAnnotation.name() + "," + cherryAnnotation.age() + "," + Arrays.toString(cherryAnnotation.score()));
            } else {
                System.out.println("Student CherryAnnotation no");
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
