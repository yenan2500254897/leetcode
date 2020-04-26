package prepare;

import java.util.*;

public class InorderTraversalAchieve {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> list = new ArrayList<>(4);

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }

        if(root.left!=null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return list;
    }

    public List<Integer> inorderTraversalNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if(root==null){
            return list;
        }
        stack.add(root);
        Queue<TreeNode> queue = new ArrayDeque<>(4);
        while (!stack.isEmpty()){
            TreeNode head = stack.peek();


            if(head.left !=null && !queue.contains(head.left)){
                stack.add(head.left);
            }else {
                if(queue.isEmpty() || !queue.contains(head)){
                    list.add(head.val);
                    queue.add(stack.pop());
                }
                if(head.right !=null && !queue.contains(head.right)){
                    stack.add(head.right);
                }
            }
        }

        return list;
    }

}
