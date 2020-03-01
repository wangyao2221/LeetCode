package WeeklyContest178.LinkedListInBinaryTree; /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import common.ListNode;
import common.Node;
import common.tree.Wrapper;

import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionWrong {
    ListNode headClone = null;

    public boolean isSubPath(ListNode head, Wrapper.TreeNode root) {
        headClone = head;
        return help(head, root);
    }

    public boolean help(ListNode head, Wrapper.TreeNode root) {
        if (root == null) {
            return false;
        }

        if (head == null) {
            return true;
        }

        if (head.val == root.val) {
            boolean left = isSubPath(head.next, root.left);
            boolean right = isSubPath(head.next, root.right);
            return left || right;
        } else {
            boolean left = isSubPath(headClone, root.left);
            boolean right = isSubPath(headClone, root.right);
            return left || right;
        }
    }

    public static void main(String[] args) {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = "test";
    }
}