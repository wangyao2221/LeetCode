package AddTwoNumbers;

public class Solution {
    /**
     * Solution v1
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers_v1(ListNode l1, ListNode l2) {
        ListNode returnList = null;
        ListNode currentNode = null;

        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val;

            int val = result % 10;
            ListNode listNode = new ListNode(val);

            if (result > 9) {
                if (l1.next != null && l2.next != null) {
                    l1.next.val += 1;
                } else if (l1.next == null && l2.next != null) {
                    l1.next = new ListNode(1);
                } else if (l1.next != null && l2.next == null) {
                    l2.next = new ListNode(1);
                } else if (l1.next == null && l2.next == null) {
                    l1.next = new ListNode(1);
                }
            }

            if (returnList == null) {
                returnList = listNode;
                currentNode = returnList;
            } else {
                currentNode.next = listNode;
                currentNode = listNode;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null && l2 == null) {
            ListNode listNode = new ListNode(l1.val);
            currentNode.next = listNode;
            currentNode = listNode;
            l1 = l1.next;
        }

        while (l2 != null && l1 == null) {
            ListNode listNode = new ListNode(l2.val);
            currentNode.next = listNode;
            currentNode = listNode;
            l2 = l2.next;
        }

        return returnList;
    }

    /**
     * Solution v2
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers_v2(ListNode l1, ListNode l2) {
        ListNode returnList = new ListNode(0);
        ListNode currentNode = returnList;

        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int result = x + y;

            int val = result % 10;
            ListNode listNode = new ListNode(val);

            if (result > 9) {
                if (l1.next != null && l2.next != null) {
                    l1.next.val += 1;
                } else if (l1.next == null && l2.next != null) {
                    l1.next = new ListNode(1);
                } else if (l1.next != null && l2.next == null) {
                    l2.next = new ListNode(1);
                } else if (l1.next == null && l2.next == null) {
                    l1.next = new ListNode(1);
                }
            }

            currentNode.next = listNode;
            currentNode = listNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return returnList.next;
    }
}