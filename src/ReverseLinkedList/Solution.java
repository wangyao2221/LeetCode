package ReverseLinkedList;

import common.ListNode;

public class Solution {
    public ListNode reverse(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        
        while(nextNode != null) {
            ListNode tmp = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = tmp;
        }
        head.next = null;
        head = currentNode;
        return head;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        ListNode head = ListNode.create(array);
        ListNode reverse = solution.reverse(head);
        ListNode.print(reverse);
    }
}