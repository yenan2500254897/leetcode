package JZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class reversePrint {
    public class ListNode {
        int val;
        ListNode next;
       ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {

        if(head == null){
            return null;
        }
        ListNode prePoint = head;
        ListNode nextPoint = head.next;
        ListNode lastPoint = null;
        while(nextPoint!=null){
            prePoint.next = lastPoint;
            lastPoint = prePoint;
            prePoint = nextPoint;
            nextPoint = nextPoint.next;
        }
        prePoint.next = lastPoint;
        List<Integer> result = new ArrayList<>(4);
        while (prePoint != null){
            result.add(prePoint.val);
            prePoint = prePoint.next;
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
