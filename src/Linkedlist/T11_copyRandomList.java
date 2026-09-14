package Linkedlist;


import java.util.HashMap;
import java.util.Map;



public class T11_copyRandomList {
    /*
    Node有两个指针,next和random
    先按next遍历一遍，用哈希表map<Node,Node>记录原节点和复制节点（只有val复制）
    再补充next,random
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node p=head;
        while(p!=null){
            map.put(p,new Node(p.val));
            p=p.next;
        }
        Node curr=head;
        while(curr!=null){
            //易错
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        return map.get(head);
    }

    /*
        原地穿插法：通过把原节点和新节点放在一起，让他们在空间复杂度为O(1)的情况下产生联系
     */
    public Node copyRandomList_better(Node head) {
        if (head == null) return null;
        //创建一个新链表，记录原链表和复制链表的结合题
        Node curr=head;
        while(curr!=null){
            Node newNd=new Node(curr.val);
            newNd.next=curr.next;
            curr.next=newNd;
            curr=newNd.next;
        }
        //连接random指针 使得A*->C*
        curr=head;
        while(curr!=null&&curr.next!=null){
            if(curr.random!=null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //拆分链表，一次跳两次 newHead.next=curr.next.next    newHead.random=curr.next.random
        curr=head;
        Node newHead=head.next;
        Node newCurr=newHead;
        while(curr!=null){
            curr.next=curr.next.next;
            if(newCurr.next!=null){
                newCurr.next=newCurr.next.next;
            }
            curr=curr.next;
            newCurr=newCurr.next;
        }
        return newHead;

    }



















}
