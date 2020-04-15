package Test.zhijian0411;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main04 {
    public static volatile int currentNumber = 0;

    public static void main(String[] args) {
        int size = 1024;
        int n = (int) Math.round(size / 10.0);
        for (int i = 0; i < n; i++) {

        }
    }

    public static class ReadFileTask implements Callable {
        private int number;
        private File file;

        public ReadFileTask(int number, File file) {
            this.number = number;
            this.file = file;
        }

        @Override
        public StringBuffer call() throws Exception {
            while (currentNumber != number) {
            }
            currentNumber++;
            return null;
        }
    }
}
