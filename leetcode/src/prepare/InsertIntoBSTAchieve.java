package prepare;

import java.util.Stack;

public class InsertIntoBSTAchieve {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode assistant = new TreeNode(val);
            return assistant;
        }

        if(root.val == val){
            return root;
        }else if(root.val > val){
             root.left = insertIntoBST(root.left, val);
        }else {
             root.right = insertIntoBST(root.right, val);
        }
        return root;
    }


}
