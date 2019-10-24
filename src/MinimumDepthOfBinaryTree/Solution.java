package MinimumDepthOfBinaryTree;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
 * Memory Usage: 38.2 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        if (leftMinDepth == 0) {
            return rightMinDepth;
        } else if (rightMinDepth == 0){
            return leftMinDepth;
        } else {
            return leftMinDepth < rightMinDepth ? leftMinDepth + 1 : rightMinDepth + 1;
        }
    }
}