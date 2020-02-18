package InvertTree;

import common.BinaryTreeNode;

class Solution {
    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root == null) return root;

        BinaryTreeNode left = root.left;
        BinaryTreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}