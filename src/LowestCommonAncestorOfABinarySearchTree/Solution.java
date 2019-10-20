package LowestCommonAncestorOfABinarySearchTree;

import common.TreeNode;

// TODO 内存消耗太大，改成非递归
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) {
            return root;
        }

        if ((root.val < p.val && root.val > q.val)
                || (root.val < q.val && root.val > p.val)) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}