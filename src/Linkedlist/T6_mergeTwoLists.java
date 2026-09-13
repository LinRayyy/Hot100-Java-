package Linkedlist;

public class T6_mergeTwoLists {

    /*
    创建一个虚拟节点p
    不去更新val,而是通过p.next=liat1的方式接入节点，这样就可以不用反复去创建新的节点
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        ListNode p1=list1;
        ListNode p2=list2;
        while(p1!=null && p2!=null){
            if(p1.val>p2.val){
                p.next=p2;
                p2=p2.next;
            }
            else{
                p.next=p1;
                p1=p1.next;
            }
            p=p.next;
        }
        if(p1!=null)p.next=p1;
        if(p2!=null)p.next=p2;

        return dummy.next;
    }




    /*
    错解：容易空指针
    合并两个升序链表。准备两个指针，分别存储两个头指针，设为p1 p2,再用一个p指针存入新指针数据
    如果p1.val>p2.val,p.val=p1.val,p=p.next;
     */
    public ListNode mergeTwoLists_false(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p=new ListNode(p1.val + p2.val + p1.val + p2.val);
        while (p1 != null || p2 != null) {
            //四种情况，两个指针有一个空，两种大小情况
            if (p1 == null){
                p.val=p2.val;
                p2=p2.next;
            }
            else if(p2==null){
                p.val=p1.val;
                p1=p1.next;
            }
            else if(p1.val>p2.val){
                p.val=p2.val;
                p2=p2.next;
            }
            else {
                p.val=p1.val;
                p1=p1.next;
            }
            p=p.next;
        }
        return p;
    }




}
