package WeeklyContest178.LinkedListInBinaryTree;

import common.ListNode;
import common.tree.Wrapper;

class Solution {
    public boolean isSubPath(ListNode head, Wrapper.TreeNode root) {
    	
    	if(root==null) return false;
    	
    	return dfs(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    
    private boolean dfs(ListNode head,Wrapper.TreeNode root) {
    	if(head==null) {
    	    return true;
        }
    	if(root==null || root.val!=head.val) {
    	    return false;
        }
    	
    	return dfs(head.next,root.left) || dfs(head.next,root.right);
    }
}