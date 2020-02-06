package BinaryTreeTilt;

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
    public int findTilt(TreeNode root) {
        return 0;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findTilt(root.left);
        int right = findTilt(root.right);

        return left + right + Math.abs(left - right);
    }
}