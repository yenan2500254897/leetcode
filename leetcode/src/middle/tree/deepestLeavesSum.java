package middle.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *  
 *
 * 提示：
 *
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class deepestLeavesSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //list 不能用等号赋值
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<TreeNode> record = new ArrayList<>();
        List<TreeNode> pre = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        pre.add(root);
        record.addAll(pre);
        while (!pre.isEmpty()){
            TreeNode node = pre.get(0);
            if(node.left != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }
            pre.remove(0);
            if(pre.isEmpty() && !next.isEmpty()){
                //show(next);
                pre.addAll(next);
                record.clear();
                next.clear();
                record.addAll(pre);
            }

        }
        int total = 0;
        for(TreeNode item:record){
            total += item.val;
        }
        return total;
    }

    public void show(List<TreeNode> list){
        for(TreeNode node:list){
            System.out.print(" " + node.val + "");
        }
        System.out.println();
    }
}
