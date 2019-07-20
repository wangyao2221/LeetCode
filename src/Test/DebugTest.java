package Test;

public class DebugTest {
    public static void main(String[] args) {
        try {
            int a = 3 / 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
