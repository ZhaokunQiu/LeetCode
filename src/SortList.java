public class SortList {

    public static void main(String[] args) {
        SortList s = new SortList();
        s.test();
    }

    private void test() {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        //n3.next = n4;
        sortList(n1);
    }

    // 快排实现（不如归并效率高）
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode ln = head;
        ListNode start = head;
        while(ln.next != null)
            ln = ln.next;
        sort(start,ln);
        return head;
    }

    private void sort(ListNode sn, ListNode en){
        if(sn == en)
            return;
        int pivot = sn.val;
        ListNode start = sn.next;
        ListNode mid = partition(sn, en, pivot);
        if(mid == null){
            sort(sn.next,en);
        }
        else {
            sort(sn, mid);
            sort(mid.next, en);
        }
    }

    private ListNode partition(ListNode sn, ListNode en, int privot){
        ListNode starti = sn;
        ListNode startj = sn.next;
        ListNode end = en;
        ListNode temp = null;
        while(startj != end.next){
            if(startj.val <= privot){
                temp = starti;
                starti = starti.next;
                swap(starti,startj);
            }
            startj = startj.next;
        }
        swap(starti,sn);
        return temp;
    }

    private void swap(ListNode n1, ListNode n2){
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    //归并实现
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
