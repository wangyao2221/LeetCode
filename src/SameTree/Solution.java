package SameTree;

import common.BinaryTreeNode;

class Solution {
    public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if ((p != null) && (q != null) && (p.val != q.val)) return false;

        return true && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}