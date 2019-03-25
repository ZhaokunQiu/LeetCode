public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        return buildSubTree(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }

    public TreeNode buildSubTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft>preRight)
            return null;
        if(preLeft == preRight)
            return new TreeNode(preOrder[preLeft]);
        TreeNode parent = new TreeNode(preOrder[preLeft]);
        int mid = inLeft;
        while(inOrder[mid]!=preOrder[preLeft])
            ++mid;
        parent.left = buildSubTree(preOrder,inOrder,preLeft+1,preLeft+(mid-inLeft),inLeft,mid-1);
        parent.right = buildSubTree(preOrder,inOrder,preLeft+(mid-inLeft)+1,preLeft+(mid-inLeft)+(inRight - mid),mid+1,inRight);
        return parent;
    }
}
