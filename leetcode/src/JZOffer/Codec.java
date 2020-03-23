package JZOffer;

import sun.font.CreatedFontTracker;

import java.util.*;

public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        List<String> result = new ArrayList<String>(1);
        List<String> list = new ArrayList<String>(1);
        Queue<TreeNode> assistant = new ArrayDeque<>(1);
        assistant.add(root);
        Queue<TreeNode> queue = new ArrayDeque<>(1);
        while (!assistant.isEmpty()){
            TreeNode node = assistant.poll();
            result.add(String.valueOf(node.val));
            if(node.left == null){
                list.add("null");
            }else {
                queue.add(node.left);
            }

            if(node.right == null){
                list.add("null");
            }else {
                queue.add(node.right);
            }
            if(assistant.isEmpty()){
                assistant.addAll(queue);
                if(!queue.isEmpty()){
                    result.addAll(list);
                }

                queue.clear();
                list.clear();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(String item:result){
            stringBuilder.append(item);
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<0){
            return null;
        }
        data = data.substring(1,data.length()-1);
        //System.out.println(data);
        if(data.isEmpty()){
            return null;
        }
        String[] nodesStr=data.split(",");
//        for(String item:nodesStr){
//            System.out.println(" "+ item + " ");
//        }
        List<String> list = Arrays.asList(nodesStr);
        Queue<TreeNode> pre=new ArrayDeque<>(1);
        Queue<TreeNode> next=new ArrayDeque<>(1);
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));

        //System.out.println(root.val);
        int index =1;
        pre.add(root);
        while (!pre.isEmpty() || !next.isEmpty()){
            while (!pre.isEmpty() && index<list.size()){
                TreeNode tempNode = pre.poll();
                //System.out.println(tempNode.val);
                String left=list.get(index);
                //System.out.println("left" + left);
                index++;
                if(!left.equals("null")){
                    TreeNode leftNode =  new TreeNode(Integer.valueOf(left));
                    tempNode.left = leftNode;
                    next.add(leftNode);
                    //System.out.println("construct left node " + tempNode.left.val);
                }

                String right=list.get(index);
                //System.out.println("right" + right);
                index++;
                if(!right.equals("null")){
                    TreeNode rightNode =  new TreeNode(Integer.valueOf(right));
                    tempNode.right = rightNode;
                    next.add(rightNode);
                    //System.out.println("construct left node " + tempNode.right.val);
                }
            }
            if(index == list.size()){
                break;
            }
            pre.addAll(next);
            next.clear();
        }
        //System.out.println("last:" + root.left.val + " "+ root.right.val);
        return root;
    }

    public void show(TreeNode root){
        Queue<TreeNode> pre=new ArrayDeque<>(1);
        Queue<TreeNode> next=new ArrayDeque<>(1);
        pre.add(root);
        while (!pre.isEmpty()){
            TreeNode temp = pre.poll();
            System.out.print(" "+ temp.val + " ");
            if(temp.left!=null){
                next.add(temp.left);
            }
            if(temp.right!=null){
                next.add(temp.right);
            }
            if(pre.isEmpty()){
                pre.addAll(next);
                next.clear();
                System.out.println();
            }
        }


    }
    public static void main(String[] args){
        String str="[1,2,3,null,null,4,5]";
        Codec codec = new Codec();
        TreeNode root =codec.deserialize(str);
        codec.show(root);
        System.out.println(codec.serialize(root));
    }
}
