package CountingBits;

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for(int i = 1;i <= num;i++) {
            if(i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i - 1] + 1;
            }
        }

        return result;
    }
}