package ConvertSortedArrayToBinarySearchTree;

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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    public TreeNode recur(int[] nums, int i, int j) {
        if (i > j) return null;
        if (i == j) return new TreeNode(nums[i]);

        int mid = (i + j) / 2;
        if ((j - i) % 2 == 1) {
            mid += 1;
        }

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = recur(nums, i, mid - 1);
        treeNode.right = recur(nums, mid + 1, j);

        return treeNode;
    }
}