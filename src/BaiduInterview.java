public class BaiduInterview {
    public int finStrategyCount(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            result++;

            if (i + 1 < str.length()) {
                int m = str.charAt(i + 1) - '0';
                int sum = n * 10 + m;

                if (sum < 26) {
                    result++;
                }
            }
        }

        return result;
    }

    public int findRotateArr(int[] arr, int x) {
        int splitIndex = findSplitIndex(arr);
        int result = binarySearch(arr, 0, splitIndex, x);

        if (result != -1){
            return result;
        }

        if (splitIndex < arr.length - 1){
            result = binarySearch(arr,splitIndex + 1, arr.length - 1, x);
        }

        return result;
    }

    public int findSplitIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;
            if (mid - 1 >= 0 && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (mid + 1 < arr.length && arr[mid + 1] < arr[mid]) {
                return mid;
            }

            if (arr[mid] < arr[low]) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return arr.length - 1;
    }

    public int binarySearch(int[] arr, int low, int high, int x) {
        int mid = 0;

        while (low < high){
            mid = (low + high) / 2;

            if (arr[mid] == x) return mid;

            if (x > arr[mid]){
                low = mid;
            }else {
                high = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new BaiduInterview().finStrategyCount("126"));
        System.out.println(new BaiduInterview().findRotateArr(new int[]{5,6,7,1,2,3,4},7));
    }
}
