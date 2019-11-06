package Test.sap;

import java.util.Arrays;

public class MaxSubStringLuckyNum {
    public static void main(String[] args) {
        int result = 0;
//        int[] sq = {9, 8, 3, 5, 7}; // 输入存到这里
        int[] sq = {1, 2}; // 输入存到这里
        int[][] max = new int[sq.length][sq.length];
        int[][] secMax = new int[sq.length][sq.length];

        for (int i = 0; i < sq.length; i++) {
            int maxTmp = 0;
            int secMaxTmp = 0;
            for (int j = i; j < sq.length; j++) {
                if (sq[j] > maxTmp) {
                    secMaxTmp = maxTmp;
                    maxTmp = sq[j];
                }
                max[i][j] = maxTmp;
                secMax[i][j] = secMaxTmp;
            }
        }

//        for (int i = 0; i < sq.length; i++) {
//            int secMaxTmp = 0;
//            for (int j = i; j < sq.length; j++) {
//                if (sq[j] < max[i][j] && sq[j] > secMaxTmp) {
//                    secMaxTmp = sq[j];
//                }
//                secMax[i][j] = secMaxTmp;
//            }
//            secMax[i][i] = max[i][i];
//        }

        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq.length; j++) {
                System.out.print(max[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq.length; j++) {
                System.out.print(secMax[i][j]);
            }
            System.out.println();
        }


        for (int i = 0; i < sq.length; i++) {
            for (int j = i; j < sq.length; j++) {
                if ((max[i][j] ^ secMax[i][j]) > result) {
                    result = max[i][j] ^ secMax[i][j];
                }
            }
        }

        System.out.println(result);
    }
}
