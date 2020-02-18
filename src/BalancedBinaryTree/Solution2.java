package BalancedBinaryTree;

import common.BinaryTreeNode;

/**
 * 这个写法和Solution1思路本质上一样，但逻辑看起来更简洁
 */
class Solution2 {
    public boolean isBalanced(BinaryTreeNode root) {
        depth(root);
        return checkBalance(root);
    }

    public boolean checkBalance(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        return checkBalance(root.left) && checkBalance(root.right) && (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1);
    }

    public int depth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        root.val = Math.max(depth(root.left), depth(root.right)) + 1;
        return root.val;
    }

    public int getDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.val;
        }
    }
}