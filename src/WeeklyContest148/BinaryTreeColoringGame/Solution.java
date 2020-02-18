package WeeklyContest148.BinaryTreeColoringGame;


import common.BinaryTreeNode;

class Solution {
    public boolean btreeGameWinningMove(BinaryTreeNode root, int n, int x) {
        if(root.val == x && root.left.left == null) return false;

        if (!find(root.left, x) && root.left.val == x) {
            return false;
        } else {
            return true;
        }
    }

    public boolean find(BinaryTreeNode root, int x) {
        if (root == null) return false;

        if (root.val == x) {
            return true;
        }

        return find(root.left, x) || find(root.right, x);
    }
}