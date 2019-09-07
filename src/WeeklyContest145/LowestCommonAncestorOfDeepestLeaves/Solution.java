package WeeklyContest145.LowestCommonAncestorOfDeepestLeaves;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode result;
    private boolean flag;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        cur(root);
        return result;
    }

    public int cur(TreeNode root){
        if (root == null) return 0;

        int left = cur(root.left);
        int right = cur(root.right);

        if (left != 0 && left == right) {
            result = root;
        }

        if (left != 0 && right == 0 && root.left.left == null && root.left.right == null) {
            result = root.left;
        } else if(left == 0 && right != 0 && root.right.left == null && root.right.right == null) {
            result = root.right;
        }

        return left > right ? left + 1 : right + 1;
    }

}

