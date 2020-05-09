package prepareSec.dp;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LongestZigZag {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //递归
//    private int maxValue = 0;
//    public int longestZigZag(TreeNode root) {
//
//        if(root == null){
//            return 0;
//        }
//
//        if(root.left != null){
//            int left = findZigZag(root.left, "left")+1;
//            int leftSon = longestZigZag(root.left);
//            maxValue = Math.max(left, Math.max(leftSon, maxValue));
//        }
//
//        if(root.right != null){
//            int right = findZigZag(root.right, "right")+1;
//            int rightSon = longestZigZag(root.right);
//            maxValue = Math.max(right, Math.max(rightSon, maxValue));
//        }
//        return maxValue;
//
//    }
//
//    public int findZigZag(TreeNode root, String preDirection){
//        if(root == null){
//            return 0;
//        }
//
//        if(preDirection == "left"){
//            if(root.right == null){
//                return 0;
//            }
//            return findZigZag(root.right, "right")+1;
//        }
//
//        if(root.left == null){
//            return 0;
//        }
//        return findZigZag(root.left, "left")+1;
//    }
//
//

    //广度优先
    private int maxValue = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null){
            return 0;
        }

        //preLeft.get(head)是指通过走左节点到达head节点的步数
        Map<TreeNode, Integer> preLeft = new HashMap<TreeNode, Integer>(4);
        //preRight.get(head)是指通过走右节点到达head节点的步数
        Map<TreeNode, Integer> preRight = new HashMap<TreeNode, Integer>(4);

        preLeft.put(root, 0);
        preRight.put(root, 0);
        Queue<TreeNode> queue = new ArrayDeque<>(4);
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(head.left != null){
                //先添加head.left
                queue.add(head.left);
                //可以通过走右节点，到达head
                if(preRight.containsKey(head)){
                    maxValue = Math.max(maxValue, preRight.get(head)+1);
                    preLeft.put(head.left, preRight.get(head)+1);
                }else {
                    //无法通过走右节点到达head
                    preLeft.put(head.left, 1);
                }
            }

            if(head.right != null){
                //先添加head.right
                queue.add(head.right);
                //可以通过走左节点，到达head
                if(preLeft.containsKey(head)){
                    maxValue = Math.max(maxValue, preLeft.get(head)+1);
                    preRight.put(head.right, preLeft.get(head)+1);
                }else {
                    //无法通过走左节点，到达head
                    preRight.put(head.right, 1);
                }
            }
        }
        return maxValue;
    }
}
