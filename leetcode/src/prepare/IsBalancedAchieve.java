package prepare;

public class IsBalancedAchieve {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(findDepth(root.left)-findDepth(root.right))<=1;
    }

    private int findDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right))+1;
    }
}
