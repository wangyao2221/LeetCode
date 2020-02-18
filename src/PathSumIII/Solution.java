package PathSumIII;

import common.BinaryTreeNode;

import java.util.HashMap;

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
    // Complexity: 
    // - Time: O(N), N is the node number of the tree
    // - Space: O(h), h is the height of the tree
    
    int helper(BinaryTreeNode root, int sum, HashMap<Integer, Integer> prefixSum, int currentSum) {
        if (root == null) return 0;
        
        currentSum += root.val;
        
        // We need to count prefixSumX that currentSum - prefixSumX = sum
        // => prefixSumX = currentSum - sum;
        int cntPrefixSumX = prefixSum.getOrDefault(currentSum - sum, 0);
        
        // Put currentSum to prefixSum map
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        
        // Find answers from child nodes
        int total = cntPrefixSumX 
            + helper(root.left, sum, prefixSum, currentSum) 
            + helper(root.right, sum, prefixSum, currentSum);
        
        // Backtracking
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) - 1);
        
        return total;
    }
    
    public int pathSum(BinaryTreeNode root, int sum) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        
        // Init prefixSum with 0
        // For example: arr=[1, 5, 3] -> prefixSum = [0, 1, 6, 9]
        prefixSum.put(0, 1);
        
        return helper(root, sum, prefixSum, 0);
    }
}