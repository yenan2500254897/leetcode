package JZOffer;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private int nodeCount=0;
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<Node, Node>(4);
        Node assistant = head;
        while(assistant != null){
            map.put(assistant, new Node(assistant.val));
            assistant = assistant.next;
        }

        assistant = head;
        while (assistant != null){
            if(assistant.next!=null){
                map.get(assistant).next = map.get(assistant.next);
            }
            if(assistant.random != null){
                map.get(assistant).random = map.get(assistant.random);
            }
            assistant = assistant.next;
        }
        return map.get(head);
    }
}
