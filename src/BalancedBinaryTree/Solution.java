package BalancedBinaryTree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int currentLevelNodeNum = 1;
        int expectCurrentLevelNodeNum = currentLevelNodeNum;

        int flag = 0;
        while (!queue.isEmpty()) {
            if (currentLevelNodeNum < expectCurrentLevelNodeNum && flag < 2) {
                flag++;
            }

            if (flag == 2) {
                return false;
            }

            int tmp = 0;
            for (int i = 0; i < currentLevelNodeNum; i++) {
                if (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                        tmp++;
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        tmp++;
                    }
                }
            }

            currentLevelNodeNum = tmp;
            expectCurrentLevelNodeNum *= 2;
        }

        return true;
    }
}