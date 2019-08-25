package Test;

public class BinarySearch {

    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(new int[]{1,2,3,4}, 4));
    }
}
