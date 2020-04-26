package prepare;

import java.util.*;

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

    public List<Integer> preorderTraversalNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if(root==null){
            return list;
        }
        stack.add(root);
        Queue<TreeNode> queue = new ArrayDeque<>(4);
        while (!stack.isEmpty()){
            TreeNode head = stack.peek();
            if(queue.isEmpty() || !queue.contains(head)){
                list.add(head.val);
                queue.add(head);
            }


            if(head.left !=null && !queue.contains(head.left)){
                stack.add(head.left);
            }else if(head.right != null && !queue.contains(head.right)){
                stack.add(head.right);
            }else {
                stack.pop();
                queue.add(head);
            }
        }

        return list;
    }
}
