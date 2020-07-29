package ForOffer.DeleteDuplication;

import common.ListNode;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode currentNode = pHead;
        ListNode preNode = new ListNode(-1);
        preNode.next = pHead;
        pHead = preNode;
        
        while(currentNode != null) {
            ListNode next = currentNode.next;
            int deplicaCount = 0;
            
            while(next != null && next.val == currentNode.val) {
                currentNode.next = next.next;
                next = currentNode.next;
                deplicaCount++;
            }
            
            if(deplicaCount > 0) {
                preNode.next = currentNode.next;
                currentNode = preNode.next;
            } else {
                preNode = currentNode;
                currentNode = preNode.next;
            }
        }
        
        return pHead.next;
    }

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 3, 4, 4, 5};
        int[] array = {1};
        ListNode head = ListNode.create(array);
        Solution solution = new Solution();
        solution.deleteDuplication(head);
    }
}