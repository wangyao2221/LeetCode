package PathSumII;

import common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Runtime: 3 ms, faster than 13.53% of Java online submissions for Path Sum II.
 * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Path Sum II.
 */
class Solution {
    public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        if (root == null) return new ArrayList<>();

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                return new ArrayList<List<Integer>>(){
                    {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(0, root.val);
                        add(list);
                    }
                };
            } else {
                return new ArrayList<>();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightList = pathSum(root.right, sum - root.val);

        for (List<Integer> list : leftList) {
            list.add(0, root.val);
            result.add(list);
        }

        for (List<Integer> list : rightList) {
            list.add(0, root.val);
            result.add(list);
        }

        return result;
    }
}