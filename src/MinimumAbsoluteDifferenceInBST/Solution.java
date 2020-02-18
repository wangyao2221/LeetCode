package MinimumAbsoluteDifferenceInBST;

import common.BinaryTreeNode;

/**
 * 中序遍历可以将元素整理成一条有序的线
 * 方便进行一些线性的操作
 * 该题可以通过该方法找元素之间的最小差值
 */
class Solution {
    int pre = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(BinaryTreeNode root) {
        help(root);
        return min;
    }

    public void help(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        help(root.left);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        help(root.right);
    }
}