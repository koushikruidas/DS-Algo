package LinkedList;

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode curr = null;
        ListNode prev = null;
        ListNode next = null;
        ListNode it = head;
        ListNode res = ( head != null && head.next != null ) ? head.next : head;
        while(it != null && it.next != null){
            curr = it;
            next = it.next;
            curr.next = next.next;
            next.next = curr;
            if(prev == null){
                prev = curr;
            }
            else {
                prev.next = next;
                prev = curr;
            }
            it = curr.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode head = swapPairs(l1);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
