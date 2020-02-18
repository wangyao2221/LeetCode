package SymmetricTree;

import common.BinaryTreeNode;

class Solution {
    public boolean isSymmetric(BinaryTreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

}