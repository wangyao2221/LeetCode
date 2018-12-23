package RangeSumBST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;

        int val = root.val;

        val = val >= L && val <= R ? val : 0;

        return val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R);
    }
}