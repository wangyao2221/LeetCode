package BinaryTreeInorderTraversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        do {
            stack.push(node);

            if (node != null) {
                node = node.left;
            } else {
                stack.pop();
                TreeNode tmp = stack.peek();
                result.add(tmp.val);
                stack.push(node.right);
                node = node.right;
            }
        } while (!stack.empty());

        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}