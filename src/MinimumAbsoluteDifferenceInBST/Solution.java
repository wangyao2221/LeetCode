package MinimumAbsoluteDifferenceInBST;

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
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        help(root, -1);
        return min;
    }

    public void help(TreeNode root, int pre) {
        if (root != null) {
            return;
        }

        help(root.left, pre);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        help(root.right, pre);
    }
}