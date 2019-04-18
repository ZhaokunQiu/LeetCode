import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root == null)
            return null;
        int size = 1;
        ArrayList<Node> list = new ArrayList<>();
        list.add(root);
        int index = 0;
        while(index < list.size()){
            size = list.size();
            while(index < size ){
                Node temp = list.get(index);
                if(index + 1 < size)
                    temp.next = list.get(index + 1);
                if(temp.left != null && temp.right != null){
                    list.add(temp.left);
                    list.add(temp.right);
                }
                index++;
            }

        }
        for(int i = 0;i < list.size() / 2;i++) {
            list.get(i).left = list.get((i << 1) + 1);
            list.get(i).right = list.get((i << 1) + 2);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
