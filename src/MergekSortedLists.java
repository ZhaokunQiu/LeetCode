public class MergekSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return mergeLists(lists,0,lists.length-1);
    }

    public ListNode mergeLists(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        if(start == end - 1){
            return mergeTwoLists(lists[start],lists[end]);
        }
        else{
            int mid = (start+end)/2;
            ListNode lln = mergeLists(lists,start,mid);
            ListNode rln = mergeLists(lists,mid+1,end);
            return mergeTwoLists(lln,rln);
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode result = head ;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val) {
                head.next = new ListNode(l1.val);
                l1=l1.next;
            }
            else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        while(l1!=null){
            head.next = new ListNode(l1.val);
            head = head.next;
            l1=l1.next;
        }
        while(l2!=null){
            head.next = new ListNode(l2.val);
            head = head.next;
            l2=l2.next;
        }
        return result.next;
    }
}
