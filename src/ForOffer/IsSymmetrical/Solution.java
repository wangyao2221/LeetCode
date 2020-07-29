package ForOffer.IsSymmetrical;/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import ForOffer.common.TreeNode;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot.left.val == pRoot.right.val) {
            return check(pRoot.left, pRoot.right);
        } else {
            return false;
        }
    }
    
    boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;
        if(left.val != right.val) return false;

        return check(left.left, right.right) && check(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.right = new TreeNode(4);

        new Solution().isSymmetrical(root);
    }
}