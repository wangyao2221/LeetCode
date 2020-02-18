package PathSum;

import common.BinaryTreeNode;

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
    public boolean hasPathSum(BinaryTreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            if (root.right.val == sum) return true;
            else return false;
        }

        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}