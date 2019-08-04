package WeeklyContest148.DecreaseElementsToMakeArrayZigzag;

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int result1 = 0, result2 = 0, offset = 0;
        int[] copyNums = nums.clone();

        for (int i = 0; i < copyNums.length; i += 2) {
            if (i != copyNums.length - 1) {
                offset = copyNums[i + 1] - copyNums[i];
                if (offset >= 0) {
                    result1 += offset + 1;
                    copyNums[i + 1] = copyNums[i + 1] - offset - 1;
                }
            }

            if (i != 0) {
                offset = copyNums[i - 1] - copyNums[i];
                if (offset >= 0) {
                    result1 += offset + 1;
                    copyNums[i - 1] = copyNums[i - 1] - offset - 1;
                }
            }
        }

        copyNums = nums.clone();

        for (int i = 1; i < copyNums.length; i += 2) {
            if (i != copyNums.length - 1) {
                offset = copyNums[i + 1] - copyNums[i];
                if (offset >= 0) {
                    result2 += offset + 1;
                    copyNums[i + 1] = copyNums[i + 1] - offset - 1;
                }
            }

            offset = copyNums[i - 1] - copyNums[i];
            if (offset >= 0) {
                result2 += offset + 1;
                copyNums[i - 1] = copyNums[i - 1] - offset - 1;
            }
        }

        return result1 < result2 ? result1 : result2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }
}