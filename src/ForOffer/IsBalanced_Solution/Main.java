package ForOffer.IsBalanced_Solution;

import ForOffer.common.TreeNode;

public class Main {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        if(root.left == null) {
            return depth(root.right) <= 1;
        } 
        if(root.right == null) {
            return depth(root.left) <= 1;
        }
        
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        return (left > right ? left : right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Main main = new Main();
        System.out.println(main.IsBalanced_Solution(root));
    }
}