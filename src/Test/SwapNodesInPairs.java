package Test;

public class SwapNodesInPairs {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        swap(head);
    }

    public static ListNode swap(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode currentNode = head;
        ListNode nextNode = head.next;
        ListNode newHead = nextNode;
        ListNode preNode = null;

        while (currentNode != null && nextNode != null) {
            currentNode.next = nextNode.next;
            nextNode.next = currentNode;

            if (preNode != null) {
                preNode.next = nextNode;
            }
            preNode = currentNode;

            currentNode = currentNode.next;
            if (currentNode != null) {
                nextNode = currentNode.next;
            }
        }

        return newHead;
    }

    public static ListNode swapListNodePairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while(p.next !=null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return dummyHead.next;
    }
}
