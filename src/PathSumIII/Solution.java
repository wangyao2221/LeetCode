package PathSumIII;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int result = 0;

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                System.out.println("1 " + root.val);
                return 1;
            }
            else return 0;
        }

        if (root.val == sum)  {
            System.out.println("2 " + root.val);
            return 1;
        }

        int leftSum = pathSum(root.left, sum - root.val) + pathSum(root.left, sum);
        int rightSum = pathSum(root.right, sum - root.val) + pathSum(root.right, sum);

        result = leftSum + rightSum + result;

        List<List<String>> data = new ArrayList<>();

//        List<String> data1 = new ArrayList<>();
//        data1.add("广东省");
//        data1.add("15");
//        data.add(data1);
//
//        List<String> data2 = new ArrayList<>();
//        data2.add("江西省");
//        data2.add("15");
//        data.add(data2);

        return result;
    }
}