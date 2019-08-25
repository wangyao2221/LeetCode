package Test;

import java.util.Scanner;

public class EncodeCheck {
    public void check(String str){
        if (str.length() < 8 || str.length() > 20) {
            System.out.println("N");
            return;
        }

        boolean condition1 = false;
        boolean condition2 = false;
        boolean condition3 = false;
        boolean condition4 = true;
        int repeat = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') condition1 = true;
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') condition2 = true;
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') condition3 = true;

            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                repeat++;
            } else {
                repeat = 1;
            }

            if (repeat >= 3) {
                condition4 = false;
            }
        }

        if (condition1 && condition2 && condition3 && condition4) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        new EncodeCheck().check(str);
    }
}
