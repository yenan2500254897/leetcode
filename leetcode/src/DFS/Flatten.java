package DFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Flatten {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        Stack<Node> stack = new Stack<Node>();
        Stack<Node> pre = new Stack<Node>();
        stack.add(head);
        int len = 0;
        while (stack.size() != len){
            Node current = stack.peek();
            len = stack.size();
            if(current.child != null){
                pre.add(current);
                stack.add(current.child);
                System.out.println("go child");
            }else if(current.next != null){
                stack.add(current.next);
                System.out.println("go next");
            }else {
                if(!pre.isEmpty()){
                    Node assitant = pre.pop();
                    while (assitant.next==null){
                        if(pre.isEmpty()){
                            break;
                        }
                        assitant.child.prev = assitant;
                        assitant.next = assitant.child;
                        assitant.child = null;
                        assitant = pre.pop();
                        System.out.println("go prev");
                    }

                    if(assitant.next!=null){
                        current.next = assitant.next;
                        assitant.next.prev = current;
                        assitant.next = assitant.child;
                        assitant.child.prev = assitant;
                        assitant.child = null;
                        stack.add(current.next);
                        System.out.println("go prev");
                    }else {
                        assitant.child.prev = assitant;
                        assitant.next = assitant.child;
                        assitant.child = null;
                    }
                }

            }
        }

        Node test = head;
        while (head!= null){
            System.out.print(" " + head.val+ " ");
            head = head.next;
        }
        return head;
    }
}
