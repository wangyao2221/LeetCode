package Test360;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        double result = 0;
        double v = 0;
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine().trim());
        double[][] arr = new double[num][2];
        for (int i = 0; i < num; i++) {
            String[] tmp = sc.nextLine().split(" " );
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }

        Arrays.sort(arr, new Comparator<double[]>() {

            @Override
            public int compare(double[] o1, double[] o2) {
                double sum1 = o1[0] * o1[1];
                double sum2 = o2[0] * o2[1];
                if (sum2 - sum1 > 0) {
                    return 1;
                } else if (sum2 - sum1 < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }

        });

        for (int i = 0; i < arr.length; i++) {
            result += v * arr[i][1] + 0.5 * arr[i][0] * arr[i][1] * arr[i][1];
            v += arr[i][0] * arr[i][1];
        }

        System.out.println((float) ((Math.round(result * 100) / 100)));
    }
}
