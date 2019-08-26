package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        int curLen = 1;

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            int tmpLen = 0;
            for (int i = 0; i < curLen; i++) {
                TreeNode node = queue.poll();

                if (!flag) {
                    integerList.add(node.val);
                } else {
                    integerList.add(0, node.val);
                }

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) {
                    queue.add(left);
                    tmpLen++;
                }
                if (right != null) {
                    queue.add(right);
                    tmpLen++;
                }
            }

            flag = !flag;
            curLen = tmpLen;
            result.add(integerList);
        }


        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new Solution().new TreeNode(3);
        root.left = new Solution().new TreeNode(9);
        root.right = new Solution().new TreeNode(20);
        root.right.left = new Solution().new TreeNode(15);
        root.right.right = new Solution().new TreeNode(7);

        List<List<Integer>> result = new Solution().zigzagLevelOrder(root);

        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
        }
        System.out.println();
    }
}