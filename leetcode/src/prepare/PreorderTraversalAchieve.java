package prepare;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversalAchieve {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> list = new ArrayList<>(4);
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
           return list;
        }

        list.add(root.val);

        if(root.left!=null){
            preorderTraversal(root.left);
        }

        if(root.right!=null){
            preorderTraversal(root.right);
        }
        return list;
    }
}
