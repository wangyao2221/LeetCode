package SumOfLeftLeaves;

import common.BinaryTreeNode;

// TODO 看其他人的解法
class Solution {
    public int sumOfLeftLeaves(BinaryTreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(BinaryTreeNode root, boolean isLeft) {
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