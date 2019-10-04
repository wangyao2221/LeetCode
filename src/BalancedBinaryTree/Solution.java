package BalancedBinaryTree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean result = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curLevelNodeNum = 1;
        int expectNextLevelNodeNum = curLevelNodeNum;
        while (!queue.isEmpty()) {
            int tmp = 0;
            for (int i = 0; i < curLevelNodeNum; i++) {
                if (!queue.isEmpty()) {
                    tmp++;
                }
            }
            curLevelNodeNum = tmp;
            if (curLevelNodeNum < expectNextLevelNodeNum) {
            }
        }

        return false;
    }
}