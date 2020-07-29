package ForOffer.TreeTraceWithoutRecursion;

import ForOffer.common.TreeNode;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author wangyao2221
 * @date 2020/7/10 14:57
 */
public class InOrder {
    public static void main1(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !set.contains(node.left)) {
                set.add(node.left);
                stack.push(node.left);
            } else {
                System.out.println(stack.pop().val);
                if (node.right != null && !set.contains(node.right)) {
                    set.add(node.right);
                    stack.push(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();

        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (node == null) {
                TreeNode tmp = stack.pop();
                System.out.println(tmp.val);
                node = tmp.right;
            }
        }
    }
}
