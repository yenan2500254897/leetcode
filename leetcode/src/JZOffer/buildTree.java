package JZOffer;

import middle.tree.maxProduct;

import java.util.Arrays;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class buildTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int index = findIndex(inorder, rootVal);
        //System.out.println("rootVal:" + rootVal + " index:" + index);
        int[] leftPreOrder = new int[0];
        int[] leftInOrder = new int[0];
        int[] rightPreOrder = new int[0];
        int[] rightInOrder = new int[0];
        if(index-1>=0){
            leftPreOrder = Arrays.copyOfRange(preorder, 1,index+1);
            leftInOrder = Arrays.copyOfRange(inorder,0, index);
        }
        if(index+1<inorder.length){
            rightPreOrder = Arrays.copyOfRange(preorder, index+1,preorder.length);
            rightInOrder = Arrays.copyOfRange(inorder,index+1, inorder.length);
        }
        // System.out.println(Arrays.toString(leftPreOrder));
        // System.out.println(Arrays.toString(leftInOrder));
        // System.out.println(Arrays.toString(rightPreOrder));
        // System.out.println(Arrays.toString(rightInOrder));
        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }



    public int findIndex(int[] inorder, int target){
        int len = inorder.length;
        for(int i=0;i<len;i++){
            if(inorder[i]==target){
                return i;
            }
        }
        return -1;
    }
}
