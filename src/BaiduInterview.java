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

    /**
     * 查找算法
     * @param arr
     * @param x 待查找元素
     * @return
     */
    public int search(int[] arr, int x) {
        int splitIndex = findSplitIndex(arr);
        // 先从0到截断位置splitIndex进行查找
        int result = binarySearch(arr, 0, splitIndex, x);

        // 如果查找成功则返回
        if (result != -1){
            return result;
        }

        // 否则在数组的后一部分，也就是从splitIndex + 1到数组末尾进行查找
        // splitIndex < arr.length - 1表示数组确实被截断了，如果数组未被截断则不用进行第二部分查找
        if (splitIndex < arr.length - 1){
            result = binarySearch(arr,splitIndex + 1, arr.length - 1, x);
        }

        return result;
    }

    /**
     * 查找截断位置
     * @param arr
     * @return 截断位置，没有截断则返回数组最后的位置
     */
    public int findSplitIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            // 当存在数组的某个位置的元素和左边或者右边的元素是逆序时，截断位置就是此处
            if (mid - 1 >= 0 && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (mid + 1 < arr.length && arr[mid + 1] < arr[mid]) {
                return mid;
            }

            // 否则更新查找的低位或高位
            if (arr[mid] < arr[low]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return arr.length - 1;
    }

    /**
     * 二分查找算法
     * @param arr
     * @param low 查找的开始位置
     * @param high 查找的结束位置
     * @param x 待查找的元素
     * @return
     */
    public int binarySearch(int[] arr, int low, int high, int x) {
        int mid = 0;

        while (low <= high){
            mid = (low + high) / 2;

            if (arr[mid] == x) return mid;

            if (x > arr[mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new BaiduInterview().finStrategyCount("126"));
        System.out.println(new BaiduInterview().search(new int[]{5,6,7,8,1,2,3,4},4));
        System.out.println(new BaiduInterview().search(new int[]{1,2,3,4,5,6,7,8},4));
    }
}
