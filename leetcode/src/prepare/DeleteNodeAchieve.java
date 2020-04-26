package prepare;

import java.util.Stack;

public class DeleteNodeAchieve {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int successor(TreeNode root){
        while (root.left!=null){
            root = root.left;
        }
        return root.val;
    }

    public int preSuccessor(TreeNode root){
        while (root.right!=null){
            root = root.right;
        }
        return root.val;
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(root.val>key){
            root.left = deleteNode(root.left, key);
        }else if(root.val<key){
            root.right = deleteNode(root.right, key);
        }else {
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right !=null){
                int temp = successor(root.right);
                root.val = temp;
                root.right = deleteNode(root.right, temp);
            }else {
                int temp = preSuccessor(root.left);
                root.val = temp;
                root.left = deleteNode(root.left, temp);
            }
        }
        return root;
    }

}
