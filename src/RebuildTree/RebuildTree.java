package RebuildTree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RebuildTree {
    HashMap map = new HashMap();
    public TreeNode rebuild(int[] levelOrder, int[] midOrder) {
        TreeNode tree = null;
        if (levelOrder.length > 0) {
            tree = new TreeNode(levelOrder[0]);
        }

        Map<Integer, Integer> midOrderIndex = new HashMap<>();

        for (int i = 0; i < midOrder.length; i++) {
            midOrderIndex.put(midOrder[i], i);
        }

        for (int i = 1; i < levelOrder.length; i++) {
            TreeNode tmp = tree;
            while (tmp != null) {
                TreeNode left = tmp.left;
                TreeNode right = tmp.right;
                if (midOrderIndex.get(levelOrder[i]) < midOrderIndex.get(tmp.val)) {
                    if (left == null) {
                        tmp.left = new TreeNode(levelOrder[i]);
                    }
                    tmp = left;
                } else {
                    if (right == null) {
                        tmp.right = new TreeNode(levelOrder[i]);
                    }
                    tmp = right;
                }
            }
        }

        return tree;
    }

    public void levelOrder(TreeNode root) {
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        RebuildTree main = new RebuildTree();
//        int[] preOrder = {1, 2, 4, 3, 6, 7};
        int[] preOrder = {1, 6, 3, 7};
//        int[] preOrder = {1, 2, 3, 4, 5, 6, 7};
//        int[] midOrder = {4, 2, 1, 6, 3, 7};
        int[] midOrder = {1, 6, 3, 7};
//        TreeNode tree = main.rebuildFromLevelOrderAndMidOrder(preOrder, midOrder);
        TreeNode tree = main.rebuild(preOrder, midOrder);
        main.preOrder(tree);
        System.out.println();
        main.midOrder(tree);
    }
}
