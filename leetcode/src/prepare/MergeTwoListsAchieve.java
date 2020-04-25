package prepare;

public class MergeTwoListsAchieve {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        int value = 0;
        if(l1.val<=l2.val){
            value=l1.val;
            l1 = l1.next;
        }else {
            value = l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(value);
        node.next = mergeTwoLists(l1, l2);
        return node;

    }
}
