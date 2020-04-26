package prepare;

import java.util.*;

public class IsValidBSTAchieve {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new ArrayDeque<>(4);

        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode head = stack.peek();
            queue.add(head);

            if(head.left!=null && !queue.contains(head.left)){
                stack.push(head.left);
            }else {
                list.add(head.val);
                queue.add(head);
                stack.pop();
                if(head.right!=null && !queue.contains(head.right)){
                    stack.add(head.right);
                }
            }
        }

        int i=0;
        for(;i<list.size();i++){
            if(!(i+1<list.size() && list.get(i)<list.get(i+1))){
                break;
            }
        }

        return i==list.size()?true:false;
    }
}
