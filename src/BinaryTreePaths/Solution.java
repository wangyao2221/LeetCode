package BinaryTreePaths;


import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// TODO 优化
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        if (root.left == null && root.right == null) {
            result.add("" + root.val);
            return result;
        }

        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);

        if (leftList.size() != 0) {
            for (int i = 0; i < leftList.size(); i++) {
                leftList.set(i, root.val + "->" + leftList.get(i));
            }
            result.addAll(leftList);
        }

        if (rightList.size() != 0) {
            for (int i = 0; i < rightList.size(); i++) {
                rightList.set(i, root.val + "->" + rightList.get(i));
            }
            result.addAll(rightList);
        }

        return result;
    }
}