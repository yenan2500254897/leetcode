package JZOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class pathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Stack<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> record = new ArrayList<>();
        if(root==null){
            return record;
        }
        result = new ArrayList<>();
        preOrder(root, new Stack<>());
        for(Stack<Integer> stack:result){
            // for(int i=0;i<stack.size();i++){
            //     System.out.print(" " + stack.get(i) + " ");
            // }
            // System.out.println();
            if(sum==calTotal(stack)){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(stack);
                record.add(temp);
            }
        }
        return record;
    }

    public void preOrder(TreeNode root, Stack<Integer> path){
        path.push(root.val);
        if(root.left == null && root.right == null){
            result.add(path);
            //path.pop();
            return;
        }
        Stack<Integer> tempStack = new Stack<>();
        tempStack.addAll(path);
        if(root.left !=null){
            preOrder(root.left, tempStack);
        }
        Stack<Integer> secStack = new Stack<>();
        secStack.addAll(path);
        if(root.right != null){
            preOrder(root.right, secStack);
        }
        //path.pop();
    }

    public int calTotal(Stack<Integer> path){
        int result = 0;
        for(Integer item:path){
            result += item;
        }
        return result;
    }
}
