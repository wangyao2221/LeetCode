package ConvertBSTToGreaterTree;

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
    int sum = 0;
    int pre = 0;
    int originPre = 0;
    boolean start = false;

    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.right);
        if (start) {
            if (originPre > root.val) {
                originPre = root.val;
                root.val = root.val + sum;
                pre = sum + root.val;
            } else if (originPre == root.val) {
                originPre = root.val;
                root.val = pre;
            }
            sum = sum + originPre;
        } else {
            originPre = root.val;
            pre = root.val;
            sum = root.val;
            start = true;
        }
        help(root.left);
    }
}