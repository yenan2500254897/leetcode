package prepare;

import java.util.List;

public class AddTwoNumbersAchieve {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1 = reverseList(l1);
//        l2 = reverseList(l2);
//        //show(l1);
//        //show(l2);
//        int carry=0;
//        ListNode head = new ListNode(0);
//        ListNode last = head;
//        ListNode lhead1 = l1;
//        ListNode lhead2 = l2;
//        while (lhead1!=null && lhead2!=null){
//            if(lhead1 == l1 && lhead2 == l2){
//                head.val = (lhead1.val+lhead2.val)%10;
//                carry = (lhead1.val+lhead2.val)/10;
//            }else {
//                ListNode assistant = new ListNode((lhead1.val+lhead2.val+carry)%10);
//                carry = (lhead1.val+lhead2.val+carry)/10;
//                last.next = assistant;
//                last = assistant;
//            }
//            lhead1 = lhead1.next;
//            lhead2 = lhead2.next;
//        }
//
//        //针对 9 -> 9
//        //         1
//        while (lhead1!=null){
//            if(lhead1 == l1){
//                last.val = (lhead1.val+carry)%10;
//                carry = (lhead1.val+carry)/10;
//                lhead1 = lhead1.next;
//                continue;
//            }
//            ListNode assistantL1 = new ListNode( (lhead1.val+carry)%10);
//            carry = (lhead1.val+carry)/10;
//            last.next = assistantL1;
//            last = assistantL1;
//            lhead1 = lhead1.next;
//        }
//
//        //针对 9 -> 9
//        //         1
//        while (lhead2!=null){
//            if(lhead2 == l2){
//                last.val = (lhead2.val+carry)%10;
//                carry = (lhead2.val+carry)/10;
//                lhead2 = lhead2.next;
//                continue;
//            }
//            ListNode assistantL2 = new ListNode((lhead2.val+carry)%10);
//            carry = (lhead2.val+carry)/10;
//            last.next = assistantL2;
//            last = assistantL2;
//            lhead2 = lhead2.next;
//        }
//
//        //针对 5
//        //    5
//        if(carry == 1){
//            ListNode carryNode = new ListNode(carry);
//            last.next = carryNode;
//            last = carryNode;
//        }
//        return reverseList(head);
//    }
//
//    private ListNode reverseList(ListNode list){
//        ListNode first = list;
//        ListNode second = null;
//        ListNode assistant = null;
//
//        while (first!=null){
//            assistant = first.next;
//            first.next = second;
//            second = first;
//            first = assistant;
//        }
//        return second;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        //show(l1);
        //show(l2);
        int carry=0;
        ListNode head = null;
        ListNode last = head;
        ListNode lhead1 = l1;
        ListNode lhead2 = l2;
        while (lhead1!=null && lhead2!=null){

            ListNode assistant = new ListNode((lhead1.val+lhead2.val+carry)%10);
            carry = (lhead1.val+lhead2.val+carry)/10;
            if(head==null){
                head = assistant;
                last = head;

            }else {
                last.next = assistant;
                last = assistant;
            }

            lhead1 = lhead1.next;
            lhead2 = lhead2.next;
        }

        //针对 9 -> 9
        //         1
        while (lhead1!=null){

            ListNode assistantL1 = new ListNode( (lhead1.val+carry)%10);
            carry = (lhead1.val+carry)/10;
            if(last==null){
                head = assistantL1;
                last = head;
            }else {
                last.next = assistantL1;
                last = assistantL1;
            }

            lhead1 = lhead1.next;
        }

        //针对 9 -> 9
        //         1
        while (lhead2!=null){

            ListNode assistantL2 = new ListNode((lhead2.val+carry)%10);
            carry = (lhead2.val+carry)/10;
            if(last==null){
                head = assistantL2;
                last=head;
            }else {
                last.next = assistantL2;
                last = assistantL2;
            }
            lhead2 = lhead2.next;
        }

        //针对 5
        //    5
        if(carry == 1){
            ListNode carryNode = new ListNode(carry);
            last.next = carryNode;
            last = carryNode;
        }
        return reverseList(head);
    }

    private ListNode reverseList(ListNode list){
        ListNode first = list;
        ListNode second = null;
        ListNode assistant = null;

        while (first!=null){
            assistant = first.next;
            first.next = second;
            second = first;
            first = assistant;
        }
        return second;
    }
    public void show(ListNode head){
        ListNode item = head;
        while (item!=null){
            System.out.print(item.val + " ");
            item = item.next;
        }
        System.out.println();
    }
}
