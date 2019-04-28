import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node,Node> record= new HashMap<>();
        Node oldHead = head;
        Node curNode = new Node();
        Node newHead = curNode;
        while(head != null) {
            curNode.val = head.val;
            if(head.next != null) {
                Node temp = new Node();
                curNode.next = temp;
            }
            record.put(head,curNode);
            curNode = curNode.next;
            head = head.next;
        }
        while(oldHead != null){
            if(oldHead.random == null){
                oldHead = oldHead.next;
                continue;
            }
            else{
                Node temp = record.get(oldHead);
                Node tempRan = record.get(oldHead.random);
                temp.random = tempRan;
                oldHead = oldHead.next;
            }
        }
        return newHead;
    }
}
