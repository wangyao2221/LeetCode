package PathSumIII;

import common.TreeNode;

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
            if (root.val == sum) return 1;
            else return 0;
        }

        if (root.val == sum) result = result + 1;

        int leftSum = pathSum(root.left, sum - root.val) + pathSum(root.left, sum);
        int rightSum = pathSum(root.right, sum - root.val) + pathSum(root.right, sum);

        result = leftSum + rightSum + result;

        return result;
    }
}