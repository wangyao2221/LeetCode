package SumOfLeftLeaves;

import common.TreeNode;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }

        int left = sumOfLeftLeaves(root.left, true);
        int right = sumOfLeftLeaves(root.right, false);

        return left + right;
    }
}