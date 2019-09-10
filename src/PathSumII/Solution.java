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
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        if (root.left == null && root.right == null) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(root.val);
            result.add(tmpList);
            return result;
        }

        List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightList = pathSum(root.right, sum - root.val);

        if (leftList.size() != 0) {
            for (int i = 0; i < leftList.size(); i++) {
                leftList.get(i).add(0,root.val);
            }
            result.addAll(leftList);
        }

        if (rightList.size() != 0) {
            for (int i = 0; i < rightList.size(); i++) {
                rightList.add(0, rightList.get(i));
            }
            result.addAll(rightList);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        list1.add(new ArrayList<>(list2));
        list2.add(4);
    }
}