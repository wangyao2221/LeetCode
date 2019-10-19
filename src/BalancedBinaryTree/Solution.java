package BalancedBinaryTree;

import common.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return checkBalance(root);
    }

    public boolean checkBalance(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (root.left == null && root.right != null) {
            if (root.right.val > 1) {
                return false;
            }
        } else if (root.right == null && root.left != null) {
            if (root.left.val > 1) {
                return  false;
            }
        } else if (Math.abs(root.left.val - root.right.val) > 1){
            return false;
        }

        boolean leftCheck = checkBalance(root.left);
        boolean rightCheck = checkBalance(root.right);

        return leftCheck && rightCheck;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        root.val = Math.max(leftDepth, rightDepth) + 1;

        return root.val;
    }
}