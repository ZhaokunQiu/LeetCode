import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

    }



    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        do {
            while (root != null) {
                temp.push(root);
                root = root.left;
            }
            if (!temp.isEmpty()) {
                TreeNode node = temp.pop();
                res.add(node.val);
                root = node.right;
            }
        } while (!temp.isEmpty() || root != null);

        for(int i = 0 ; i < res.size() - 1;++i)
            if(res.get(i)>=res.get(i+1))
                return false;
        return true;
    }
    //16:18


    private int[] ee = new int[10000];
    private ArrayList<Integer> res = new ArrayList<>();
    public boolean isValidBST2(TreeNode root){
        midSearch(root);
        for(int i = 0 ; i < res.size() - 1;++i)
            if(res.get(i)>=res.get(i+1))
                return false;
        return true;
    }

    public void midSearch(TreeNode root){
        if(root == null)
            return;
        midSearch(root.left);
        res.add(root.val);
        midSearch(root.right);
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
