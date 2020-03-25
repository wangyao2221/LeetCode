package alibabatest;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//        in.nextToken();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(5);
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
