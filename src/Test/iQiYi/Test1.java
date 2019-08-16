package Test.iQiYi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void print(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        int curLen = 1;

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            int tmpLen = 0;
            for (int i = 0; i < curLen; i++) {
                TreeNode node = queue.poll();

                if (!flag) {
                    integerList.add(node.val);
                } else {
                    integerList.add(0, node.val);
                }

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) {
                    queue.add(left);
                    tmpLen++;
                }
                if (right != null) {
                    queue.add(right);
                    tmpLen++;
                }
            }

            flag = !flag;
            curLen = tmpLen;
            result.add(integerList);
        }

        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        print(root);
    }
}
