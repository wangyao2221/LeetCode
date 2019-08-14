package BinaryTreeInorderTraversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        stack.push(node);

        while (!stack.empty()) {
            if (node == null) {
                result.add(node.val);
                stack.push(node.right);
            } else {
                stack.push(node.left);
            }
        }

        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}