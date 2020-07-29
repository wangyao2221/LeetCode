package ForOffer.Print;

import ForOffer.common.TreeNode;

import java.util.ArrayList;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        int layer = 0;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        
        stack1.add(pRoot);
        int currentSize = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if(layer % 2 == 0) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                int tmpSize = 0;
                
                for(int i = 0; i < currentSize; i++) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if(node.left != null) {
                        stack2.push(node.left);
                        tmpSize++;
                    }
                    if(node.right != null) {
                        stack2.push(node.right);
                        tmpSize++;
                    }
                }
                
                currentSize = tmpSize++;
                layer++;
                result.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                int tmpSize = 0;
                
                for(int i = 0; i < currentSize; i++) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if(node.right != null) {
                        stack1.push(node.right);
                        tmpSize++;
                    }
                    if(node.left != null) {
                        stack1.push(node.left);
                        tmpSize++;
                    }
                }
                
                currentSize = tmpSize++;
                layer++;
                result.add(list);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        solution.Print(root);
    }
}