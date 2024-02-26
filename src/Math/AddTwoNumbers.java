package Math;

import LinkedList.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode();
        ListNode head = res;
        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            int sum = a + b + carry;
            int val = sum % 10;
            carry = sum / 10;
            res.next = new ListNode(val);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && carry != 0) {
            int sum = l1.val + carry;
            res.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            res = res.next;
        }

        while (l2 != null && carry != 0) {
            int sum = l2.val + carry;
            res.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            res = res.next;
        }
        if (l1 == null && l2 == null && carry != 0){
            res.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode res = addTwoNumbers(l1, l2);
        while(res != null){
            System.out.print(res.val +" -> ");
            res = res.next;
        }
    }
}
