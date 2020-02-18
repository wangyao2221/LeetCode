package FindModeInBinarySearchTree;

import common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个解法主要是根据题目意思进行中序遍历
 * 因为根据提议相同元素一定是中序遍历中连续的元素
 * 只需要找出中序遍历中连续元素最多的元素找出来即可
 * 并且由于是连续的元素因此不需要记录所有元素的数量
 * 只需要记录当前元素的数量并且和此前得到的最多的元素即可找出数量最多的元素
 */
class Solution2 {
    List<Integer> list = new ArrayList<>();
    int count = 0, max = 0;
    BinaryTreeNode preNode = null;

    public int[] findMode(BinaryTreeNode root) {
        preNode = root;
        help(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void help(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);

        if (preNode != null && preNode.val == root.val) {
            count++;
        } else {
            count = 1;
        }

        if (count > max) {
            list.clear();
            list.add(root.val);
            max = count;
        } else if (count == max){
            list.add(root.val);
        }
        preNode = root;
        help(root.right);
    }
}