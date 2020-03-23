package JZOffer;

public class TreeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    private Node pre = null;
    private Node head= null;
    private Node tail = null;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        middleOrder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void middleOrder(Node root){
        if(root == null){
            return ;
        }
        middleOrder(root.left);
        if(pre==null){
            head = root;
        }else {
            pre.right=root;
            root.left = pre;
        }
        pre = root;
        tail = root;
        middleOrder(root.right);
    }

}
