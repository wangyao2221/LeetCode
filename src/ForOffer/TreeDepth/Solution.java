package ForOffer.TreeDepth;

import ForOffer.common.TreeNode;

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if(left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
}