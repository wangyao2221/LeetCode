package ForOffer.TreeTraceWithoutRecursion;

import ForOffer.common.TreeNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author wangyao2221
 * @date 2020/7/10 14:57
 */
public class PostOrder {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();

        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !set.contains(node.left)) {
                set.add(node.left);
                stack.push(node.left);
            } else if (node.right != null && !set.contains(node.right)){
                set.add(node.right);
                stack.push(node.right);
            } else {
                System.out.println(stack.pop().val);
            }
        }
    }
}
