package WeeklyContest144.DeleteNodesAndReturnForest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        delNodes(root, to_delete, result);
        return result;
    }

    public void delNodes(TreeNode root, int[] to_delete, List<TreeNode> result) {
        if (root == null) return;
        if (Arrays.binarySearch(to_delete, 0, to_delete.length, root.val) != -1) {
            root = null;
            if (root.left != null && Arrays.binarySearch(to_delete, 0, to_delete.length, root.left.val) != -1){
                result.add(root.left);
            } else {
                delNodes(root.left, to_delete, result);
            }

            if (root.right != null && Arrays.binarySearch(to_delete, 0, to_delete.length, root.right.val) != -1){
                result.add(root.right);
            } else {
                delNodes(root.right, to_delete, result);
            }
        } else {
            result.add(root);
            delNodes(root.left, to_delete, result);
            delNodes(root.right, to_delete, result);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{3, 5}, 0, 2, 1));
//        Solution solution = new Solution();
//
//        int[] input = {1,2,3,4,5,6,7};
//
//        TreeNode treeNode = solution.new TreeNode(1);
//        treeNode.left = solution.new TreeNode(2);
//        treeNode.right = solution.new TreeNode(3);
//
//        treeNode.left.left = solution.new TreeNode(4);
//        treeNode.left.right = solution.new TreeNode(5);
//        treeNode.right.left = solution.new TreeNode(6);
//        treeNode.right.right = solution.new TreeNode(7);
//
//        System.out.println(solution.delNodes(treeNode,new int[]{3,5}));
    }
}