package FindModeInBinarySearchTree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * TODO 此解法不高效，尝试更高效的解法
 */
class Solution1 {
    int max = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        help(root, map);
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                resultList.add(key);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public void help(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        int key = root.val;
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }

        if (map.get(key) > max) {
            max = map.get(key);
        }

        help(root.left, map);
        help(root.right, map);
    }
}