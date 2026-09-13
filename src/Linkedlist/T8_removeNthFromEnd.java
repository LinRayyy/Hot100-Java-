package Linkedlist;

public class T8_removeNthFromEnd {
    /*
    1.先扫描一遍，判断一共有几个节点，然后计算是第几个节点需要删除
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点，用来统一处理删除头节点的边界！非常推荐
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy.next;
        int count=0;
        while(p!=null){
            count++;
            p=p.next;
        }
        //需要删除的序号为count-n+1，删除节点前面对应的节点序号为count-n;
        //先保存next信息，然后把next与序号为count-n的节点相连
        int target=count-n;
        p=dummy;
        // 走到前驱节点
        for(int i = 0; i < target; i++){
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;

    }
}
