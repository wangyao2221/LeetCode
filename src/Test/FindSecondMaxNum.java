package Test;

public class FindSecondMaxNum {
    public static void main(String[] args) {
        int[] arr = {1,10,3,14,25};
        int max = 0;
        int secMax = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                secMax = max;
                max = arr[i];
            }
        }

        System.out.println(secMax);
    }
}
