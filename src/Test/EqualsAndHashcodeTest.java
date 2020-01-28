package Test;

public class EqualsAndHashcodeTest {
    static class Test {
        int a = 0;
        int b = 0;

        public Test() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        @Override
        public boolean equals(Object obj) {
            if (this.a == ((Test)obj).a && this.b == ((Test)obj).b) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test1 = new Test();
        Test test2 = new Test();
        System.out.println(test1.equals(test2));
        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
    }
}
