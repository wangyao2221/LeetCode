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
 * [1,-2,-3,1,3,-2,null,-1]
 * 3
 */
class SolutionWrong {
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, sum);
    }

    public int pathSum(TreeNode root, int sum, int originSum) {
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

        int leftSum = pathSum(root.left, sum - root.val, originSum) + pathSum(root.left, originSum, originSum);
        int rightSum = pathSum(root.right, sum - root.val, originSum) + pathSum(root.right, originSum, originSum);

        System.out.println(root.val + " left:" + leftSum);
        System.out.println(root.val + " right" + rightSum);
        result = leftSum + rightSum + result;

        List<List<String>> data = new ArrayList<>();

        return result;
    }
}