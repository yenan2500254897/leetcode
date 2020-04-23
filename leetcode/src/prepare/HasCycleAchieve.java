package prepare;

public class HasCycleAchieve {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {

        boolean flag = false;
        if(head == null){
            return flag;
        }

        ListNode firstptr = head;
        ListNode secondptr = head;

        while (secondptr!=null){
            secondptr = secondptr.next;
            if(secondptr==null){
                break;
            }

            if(secondptr == firstptr || secondptr.next == firstptr){
                flag = true;
                break;
            }
            firstptr = firstptr.next;
            secondptr = secondptr.next;
        }

        return flag;
    }
}
