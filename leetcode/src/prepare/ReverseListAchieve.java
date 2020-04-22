package prepare;

public class ReverseListAchieve {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = head;
        ListNode next = null;
        ListNode assistant = null;

        while (pre!=null){
            assistant =pre.next;
            pre.next = next;
            next = pre;
            pre = assistant;
        }

        return next;
    }


}
