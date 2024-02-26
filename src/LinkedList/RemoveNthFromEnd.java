package LinkedList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        ListNode rmNode = head;
        ListNode prevNode = head;
        int i = 1;
        while(tmp.next != null){
            prevNode = tmp;
            tmp = tmp.next;
            i++;
        }
        if (tmp == null ){
            return head;
        }
        while( tmp.next != null){
            rmNode = rmNode.next;
            tmp = tmp.next;
        }
        rmNode.next = tmp;
        return head;
    }
}



