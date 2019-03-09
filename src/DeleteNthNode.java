import javax.lang.model.type.NullType;

public class DeleteNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode oldHead =new ListNode(0);
        oldHead.next = head;
        int length =1;
        while(head.next!=null){
            ++length;
            head = head.next;
        }
        head = oldHead;
        for(int i=0;i<length-n;++i){
            head = head.next;
        }
        head.next=head.next.next;
        return oldHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
