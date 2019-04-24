public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode node){
        if(node == null)
            return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        max  = left + right + node.val > max ? left + right + node.val : max;
        return node.val + Math.max(left, right);
    }
}
