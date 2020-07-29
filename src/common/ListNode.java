package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode create(int[] array) {
        if (array.length == 0) return null;
        ListNode head = new ListNode(array[0]);
        ListNode currentNode = head;

        for (int i = 1; i < array.length; i++) {
            currentNode.next = new ListNode(array[i]);
            currentNode = currentNode.next;
        }

        return head;
    }

    public static void print(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
    }
}