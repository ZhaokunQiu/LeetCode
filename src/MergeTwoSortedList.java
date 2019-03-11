public class MergeTwoSortedList {

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
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
