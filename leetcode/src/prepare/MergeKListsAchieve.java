package prepare;

import java.util.Arrays;

public class MergeKListsAchieve {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        ListNode[] positions = new ListNode[len];
        //记录各个链表的节点走到哪了
        positions = lists;

        for(ListNode item:lists){
            System.out.println(item.val + " ");
        }

        //用于第一次进入循环时使用
        boolean flag = true;
        //记录头部值最大的列表的索引
        int index = 0;
        //记录头部值最大的列表的头部
        ListNode selectNode = null;
        ListNode head = null;
        ListNode pre = null;
        while (flag || selectNode!=null){
            selectNode = null;
            index = 0;

            //遍历所有列表的头部，选出一个值最小的
            for(int i=0;i<len;i++){
                if(selectNode == null){
                    selectNode = positions[i];
                    index = i;
                }else {
                    if(positions[i]!=null && positions[i].val<selectNode.val){
                        selectNode = positions[i];
                        index = i;
                    }
                }
            }

            if(selectNode == null){
                break;
            }

            ListNode assistant = new ListNode(selectNode.val);

            if(flag == true){
                head = assistant;
                pre = head;
            }else {
                pre.next = assistant;
                pre = assistant;
            }

            flag = false;
            positions[index] = positions[index].next;
        }

        return head;
    }

    public void show(ListNode[] lists){
        for(ListNode item:lists){
            if(item!=null){
                System.out.print(item.val + " ");
            }

        }
        System.out.println();
    }
}
