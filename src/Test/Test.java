package Test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] strs = {"aa","bb", "cc"};
        System.out.println(Arrays.toString(strs));
        for (int i = 0; i < strs.length; i++) {
            strs[i] = i + "";
        }

        for (String str : strs) {
            System.out.println(str);
        }
    }
}
