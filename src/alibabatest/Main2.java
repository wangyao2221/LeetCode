package alibabatest;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] arrCopy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                arrCopy[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            int start = -1;
            int end = -1;
            int gap = 0;
            int diff = 0;
            for (int j = 0; j < m; j++) {
                if (start == -1 && arr[i][j] != 0) {
                    start = j;
                } else if (end == -1 && arr[i][j] != 0) {
                    end = j;
                }

                if (start != -1 && end != -1) {
                    gap = end - start;
                    diff = (arr[i][end] - arr[i][start]) / gap;
                    break;
                }
            }
            if (start != -1 && end != -1) {
                for (int j = start - 1; j >= 0; j--) {
                    arr[i][j] = arr[i][j + 1] - diff;
                }

                for (int j = start + 1; j < end; j++) {
                    arr[i][j] = arr[i][j - 1] + diff;
                }

                for (int j = end + 1; j < m; j++) {
                    arr[i][j] = arr[i][j - 1] + diff;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int start = -1;
            int end = -1;
            int gap = 0;
            int diff = 0;
            for (int j = 0; j < n; j++) {
                if (start == -1 && arrCopy[j][i] != 0) {
                    start = j;
                } else if (end == -1 && arrCopy[j][i] != 0) {
                    end = j;
                }

                if (start != -1 && end != -1) {
                    gap = end - start;
                    diff = (arrCopy[end][j] - arrCopy[start][j]) / gap;
                    break;
                }
        }
            if (start != -1 && end != -1) {
                for (int j = start - 1; j >= 0; j--) {
                    arrCopy[j][i] = arrCopy[j + 1][i] - diff;
                }

                for (int j = start + 1; j < end; j++) {
                    arrCopy[j][i] = arrCopy[j - 1][i] + diff;
                }

                for (int j = end + 1; j < n; j++) {
                    arrCopy[j][i] = arrCopy[j][i - 1] + diff;
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (arr[x - 1][y - 1] == 0 && arrCopy[x - 1][y - 1] == 0) {
                System.out.println("Unknown");
            } else if (arr[x - 1][y - 1] != 0 && arrCopy[x - 1][y - 1] == 0) {
                System.out.println(arr[x - 1][y - 1]);
            } else if (arr[x - 1][y - 1] == 0 && arrCopy[x - 1][y - 1] != 0) {
                System.out.println(arrCopy[x - 1][y - 1]);
            } else {
                System.out.println(arr[x - 1][y - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arrCopy[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
