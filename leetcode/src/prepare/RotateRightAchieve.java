package prepare;

import java.util.HashMap;
import java.util.Map;

public class RotateRightAchieve {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode rotateRight(ListNode head, int k) {
        //求链表节点数
        int total = 0;
        ListNode first = head;
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>(4);
        while (first!=null){
            total++;
            map.put(total, first);
            first=first.next;
        }
        //空链表、不旋转、旋转次数k是total的整数倍
        if(total == 0 || k==0 || k%total==0){
            return head;
        }

        //k对节点总数取余
        k = k%total;
        //System.out.println(k + " " + total);
        int target = total-k;

        //将target对应的节点的next改为null
        map.get(target).next = null;

        //pre为新的头节点
        int preIndex = target+1;
        if(preIndex>total){
            preIndex %= total;
        }
        ListNode pre = map.get(preIndex);
        //将原来的最后一个节点的next改为原来的head节点
        ListNode last = map.get(total);
        last.next = head;
        return pre;

    }
}
