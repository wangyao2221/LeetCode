package SingleNumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = nums[i] ^ result;
        }
        return result;
    }

    /**
     * TODO 分析这段代码为什么会比上面这段代码更耗时更耗空间
     * 分析：int是类型的数据时放在常量池中，所以每个数字无论是哪个变量存储都是在固定的内存地址（占用容量）
     * 上下两种方法异或得出的值都是一样多，所以异或计算得到的结果两者占用的内存是一样的
     * 这段代码多出来的是计算i + 1，nums.length - 1的时间和空间
      */
    public int singleNumber1(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] = nums[i] ^ nums[i + 1];
        }
        return nums[nums.length - 1];
    }

    // 用了辅助空间的较好解法
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        for(int i : set) {
            return i;
        }

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 1}));
    }
}