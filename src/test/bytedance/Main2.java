package test.bytedance;

import java.util.*;

/**
 * @author wangyao2221
 * @date 2020/7/25 10:06
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            HashSet<String> set = new HashSet<String>();
            String line = sc.nextLine();
            String[] arr = line.split(" ");

            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }

            String result = "";
            for (String s : set) {
                result += s + " " + s + " ";
            }
            System.out.println(result.substring(0, result.length() - 1));
        }
    }
}
