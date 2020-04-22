package prepare;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEndAchieve {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //两次遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total=0;
        ListNode first = head;
        while (first!=null){
            total+=1;
            first = first.next;
        }

        int index = 1;
        ListNode prenode = head;
        ListNode nextnode = null;
        while (index!=(total-n+1)){
            nextnode = prenode;
            prenode = prenode.next;
            index++;
        }
        if(nextnode!=null){
            nextnode.next = prenode.next;
        }else {
            head = prenode.next;
        }

        return head;
    }

    //一次遍历：需要用额外的空间存储节点
    public ListNode removeNthFromEndSec(ListNode head, int n) {
        int total=0;
        ListNode first = head;
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>(4);
        while (first!=null){
            total+=1;
            map.put(total, first);
            first = first.next;
        }

        int target = total-n+1;
        if(target != 1){
            map.get(target-1).next = map.get(target).next;
        }else {
            head = map.get(1).next;
        }

        return head;
    }
}
