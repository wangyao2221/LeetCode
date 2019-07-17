package HouseRobber;

class SolutionWithoutArray {
//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//
//        int first = 0, second = 0, third = 0,result = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (first + nums[i] > second) {
//                result = first + nums[i];
//                first = second;
//                second = result;
//            } else {
//                result = second;
//                second = first + nums[i];
//                first = result;
//            }
//        }
//
//        return result;
//    }

    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int n : nums) {
            int temp = curr;
            //if rob this house, then use prev+n, prev
            //if don't rob this house, then current will keep the previous amount
            curr = Math.max(prev + n, curr);
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
//        int[] input =  {2,7,9,3,1};
//        int[] input =  {1,1};
        int[] input = {2,1,1,2};
        System.out.println(new SolutionWithoutArray().rob(input));
    }
}