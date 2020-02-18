package BinaryTreeInorderTraversal;


import common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode node = root;

        do {
            stack.push(node);

            if (node != null) {
                node = node.left;
            } else {
                stack.pop();
                BinaryTreeNode tmp = stack.peek();
                result.add(tmp.val);
                stack.push(node.right);
                node = node.right;
            }
        } while (!stack.empty());

        return result;
    }
}