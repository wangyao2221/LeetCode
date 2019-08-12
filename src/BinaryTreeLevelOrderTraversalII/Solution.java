package BinaryTreeLevelOrderTraversalII;

import java.security.Key;
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNodeWithDept> queue = new LinkedList<>();
        Stack<TreeNodeWithDept> stack = new Stack<>();

        queue.add(new TreeNodeWithDept(root, 0));
        stack.push(new TreeNodeWithDept(root, 0));

        while (!queue.isEmpty()) {
            TreeNodeWithDept node = queue.poll();
            TreeNode left = node.node.left;
            TreeNode right = node.node.right;

            if (left != null) {
                stack.push(new TreeNodeWithDept(left, node.dept + 1));
                queue.add(new TreeNodeWithDept(left,node.dept + 1));
            }

            if (right != null) {
                stack.push(new TreeNodeWithDept(right, node.dept + 1));
                queue.add(new TreeNodeWithDept(right,node.dept + 1));
            }
        }

        while (!stack.isEmpty()) {
            TreeNodeWithDept node = stack.pop();

        }

        return null;
    }

    public class TreeNodeWithDept {
        TreeNode node;
        int dept;

        public TreeNodeWithDept(TreeNode node, int dept) {
            this.node = node;
            this.dept = dept;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}