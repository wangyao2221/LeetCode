package MaximumDepthOfNAryTree;

import common.Node;

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            if (depth > max) {
                max = depth;
            }
        }

        return max + 1;
    }
}