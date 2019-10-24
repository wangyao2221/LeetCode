package MinimumDepthOfBinaryTree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
 * Memory Usage: 38.4 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
 */
class SolutionNotRecursion {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevelLength = 0;
        int currentLevel = 0;

        if (root != null) {
            queue.offer(root);
            currentLevel++;
            currentLevelLength = 1;
        }

        while (!queue.isEmpty()) {
            int tmp = 0;

            for (int i = 0; i < currentLevelLength; i++) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return currentLevel;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    tmp++;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    tmp++;
                }
            }

            currentLevel++;
            currentLevelLength = tmp;
        }

        return currentLevel;
    }
}