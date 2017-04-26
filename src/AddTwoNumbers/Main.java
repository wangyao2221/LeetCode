package AddTwoNumbers;

/**
 * Created by wangyao2221 on 4/26/2017.
 */
public class Main {

    public static void main(String[] args) {
        /*
        test cases :
        [1],[9,9]
        [9],[9,9]
        [9,9] [9,9]
         */
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(6);

        l2.next = l3;
        l1.next = l2;

        ListNode l4 = new ListNode(0);

        ListNode result = Solution.addTwoNumbers_v2(l1, l4);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
