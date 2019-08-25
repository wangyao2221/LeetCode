package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PlusLinklistNum {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    class Linkedlist {
        Node head;

        public void add(int val) {
            Node node = new Node(val);

            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = node;
        }
    }

    public void plus(Linkedlist list1, Linkedlist list2) {
        Linkedlist result = new Linkedlist();
        Stack<Integer> resultStack = new Stack<>();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Node currentNode = list1.head;
        while (currentNode != null) {
            stack1.push(currentNode.val);
            currentNode = currentNode.next;
        }

        currentNode = list2.head;
        while (currentNode != null) {
            stack2.push(currentNode.val);
            currentNode = currentNode.next;
        }

        boolean carry = false; // 是否进位
        while (!stack1.empty() || !stack2.empty()) {
            int num1 = 0;
            if (!stack1.empty()) {
                num1 = stack1.pop();
            }

            int num2 = 0;
            if (!stack2.empty()) {
                num2 = stack2.pop();
            }

            int sum = num1 + num2;
            if (carry) {
                sum += 1;
            }

            if (sum >= 10) {
                resultStack.push(sum - 10);
                carry = true;
            } else {
                resultStack.push(sum);
                carry = false;
            }
        }

        boolean first = true;
        while (!resultStack.empty()) {
            if (first) {
                System.out.print(resultStack.pop());
                first = false;
            } else {
                System.out.print(" " + resultStack.pop());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Linkedlist list1 = new PlusLinklistNum(). new Linkedlist();
        Linkedlist list2 = new PlusLinklistNum(). new Linkedlist();

        Scanner scanner = new Scanner(System.in);
        String[] nums1 = scanner.nextLine().split(" ");
        String[] nums2 = scanner.nextLine().split(" ");

        for (int i = 0; i < nums1.length; i++) {
            if (i == 0) {
                list1.head = new PlusLinklistNum().new Node(Integer.parseInt(nums1[i]));
            } else {
                list1.add(Integer.parseInt(nums1[i]));
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (i == 0) {
                list2.head = new PlusLinklistNum().new Node(Integer.parseInt(nums2[i]));
            } else {
                list2.add(Integer.parseInt(nums2[i]));
            }
        }

        new PlusLinklistNum().plus(list1,list2);
    }
}
