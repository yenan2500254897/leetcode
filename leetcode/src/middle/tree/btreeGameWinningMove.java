package middle.tree;

/**
 * 1145. 二叉树着色游戏
 * 之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色。
 *
 * 如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
 *
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 *
 *  
 *
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * 输出：True
 * 解释：第二个玩家可以选择值为 2 的节点。
 *  
 *
 * 提示：
 *
 * 二叉树的根节点为 root，树上由 n 个节点，节点上的值从 1 到 n 各不相同。
 * n 为奇数。
 * 1 <= x <= n <= 100
 *
 */

public class btreeGameWinningMove {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode nodeX = findX(root, x);
        return (n-calNodeCount(nodeX) > calNodeCount(nodeX)) || (calNodeCount(nodeX.left) > n - calNodeCount(nodeX.left)) || (calNodeCount(nodeX.right) > n - calNodeCount(nodeX.right));
    }

    public TreeNode findX(TreeNode root, int x){
        if(root == null){
            return null;
        }
        if(root.val == x){
            return root;
        }
        TreeNode left = findX(root.left, x);
        TreeNode right = findX(root.right, x);
        if(left != null){
            return left;
        }
        return right;
    }
    public int calNodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + calNodeCount(root.left) + calNodeCount(root.right);
    }
}
