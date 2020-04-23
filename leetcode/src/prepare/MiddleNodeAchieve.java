package prepare;

public class MiddleNodeAchieve {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        if(head == null){
            return head;
        }

        //走在前面的指针
        ListNode firstPtr = head.next;
        ListNode secondPtr = head;

        while (firstPtr!=null){
            firstPtr = firstPtr.next;
            if(firstPtr==null){
                secondPtr = secondPtr.next;
                break;
            }

            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        return secondPtr;
    }
}
