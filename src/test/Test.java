package test;

import ForOffer.common.TreeNode;

/**
 * @author wangyao2221
 * @date 2020/7/28 14:23
 */
public class Test {
    public static int depth(TreeNode root) {
        if(root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        if(left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(depth(root));
    }
}
