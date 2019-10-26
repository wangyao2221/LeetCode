package PathSumII;

import common.TreeNode;

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
 * TODO 优化时间复杂度
 */
class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
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
        }
        result.addAll(leftList);

        for (List<Integer> list : rightList) {
            list.add(0, root.val);
        }
        result.addAll(rightList);

        return result;
    }
}