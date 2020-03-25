package Test.annotationTest;

public class Student {
//    @CherryAnnotation(name = "wangyao2221", age = 25, score = {90, 90, 90})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Good Good Study, Day Day Up!");
        }
    }
}
