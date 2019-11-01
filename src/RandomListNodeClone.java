public class RandomListNodeClone {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null)
                return null;
            copyNext(pHead);
            copyRandom(pHead);
            return takeApart(pHead);
        }

        void copyNext(RandomListNode list) {
            RandomListNode head = list;
            while (head != null) {
                RandomListNode temp = new RandomListNode(head.label);
                temp.next = head.next;
                head.next = temp;
                head = temp.next;
            }
        }

        void copyRandom(RandomListNode list) {
            RandomListNode head = list;
            while (head != null) {
                if (head.random != null)
                    head.next.random = head.random.next;
                head = head.next.next;
            }
        }

        RandomListNode takeApart(RandomListNode list) {
            RandomListNode head = list;
            RandomListNode res = list.next;
            RandomListNode cl = res;
            while (res != null && res.next != null) {
                head.next = res.next;
                head = head.next;
                res.next = head.next;
                res = res.next;
            }
            head.next = null;
            return cl;
        }


    public static void main(String[] args) {
        RandomListNodeClone r = new RandomListNodeClone();
        RandomListNode head = new RandomListNode(1);
        RandomListNode list  = head;
        list.next = new RandomListNode(2);
        list = list.next;
        list.next = new RandomListNode(3);
        head.random = list.next;
        r.Clone(head);
    }

}
