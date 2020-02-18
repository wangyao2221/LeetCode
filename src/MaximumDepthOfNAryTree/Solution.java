package MaximumDepthOfNAryTree;

import common.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (TreeNode child : root.children) {
            int depth = maxDepth(child);
            if (depth > max) {
                max = depth;
            }
        }

        return max + 1;
    }
}