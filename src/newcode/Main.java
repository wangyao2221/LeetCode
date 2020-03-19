package newcode;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 思路：某点看它上面的有没有在它右边
 * 先对点按y轴从小到大排序，就不需要去遍历在它上面的了，遍历数据的时候比当前元素先被遍历的就是在它上面的
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int n = (int) in.nval;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n;i++) {
            in.nextToken();
            arr[i][0] = (int) in.nval;
            in.nextToken();
            arr[i][1] = (int) in.nval;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

//        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i][0] + " " + arr[i][1]);
//        }

        int maxx = arr[0][0];
        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= maxx) {
                out.println(arr[i][0] + " " + arr[i][1]);
                out.flush();
                maxx = arr[i][0];
            }
        }

    }
}