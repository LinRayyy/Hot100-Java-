package Linkedlist;

import java.util.HashMap;

public class LRUCache {
    /*
    使用哈希表进行O(1)级别的查询 map<key,Dnode>
    使用双端链表完成O(1)级别的更新。虚拟哨兵dummyHead完成数据更新，dummyTail完成数据的淘汰
     */

    private HashMap<Integer, Dnode> map;
    private int capacity;
    private Dnode dummyHead;
    private Dnode dummyTail;

    static class Dnode{
        int key;
        int val;
        Dnode prev;
        Dnode next;
        public Dnode(int key,int x){
            this.key = key;
            val = x;
        }
    }

    public LRUCache(int capacity) {
        //初始化LRUCache ,两个虚拟哨兵，哈希表
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new Dnode(-1,0);
        dummyTail = new Dnode(-2,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        //先通过哈希表获取node
        Dnode curr = map.get(key);
        //如果失败，返回-1
        if (curr == null) return -1;
        //移到头部
        moveToHead(curr);

        //如果成功，返回node.val
        return curr.val;
    }



    public void put(int key, int value) {
        //先检查哈希表是否含有key
        Dnode curr = map.get(key);
        //如果含有，则直接更新节点的值
        if(curr!=null){
            curr.val = value;
            moveToHead(curr);
            map.put(key, curr);
        }else{
            //如果没有，先检查长度是否超过
            if(map.size()<capacity) {
                //如果没超过，在哨兵head处添加新节点
                curr = new Dnode(key,value);
                addDnode(curr);
            }else{
            //如果超过，删除在tail处删除节点，再在哨兵head处添加新节点
                removeDnode();
                curr = new Dnode(key,value);
                addDnode(curr);
                }
            }
    }

    private void removeDnode() {
        //先获取末尾的双端节点
        Dnode lastDnode=dummyTail.prev;
        int key=lastDnode.key;
        //根据key值删除哈希表里的节点
        map.remove(key);
        //在双端列表末尾删除节点
        Dnode prevDnode=lastDnode.prev;
        prevDnode.next = dummyTail;
        dummyTail.prev = prevDnode;
    }

    private void addDnode(Dnode curr) {
        //dummyHead.next=curr  curr.prev=dummyHead  curr.next=dummyHead.next
        curr.next=dummyHead.next;
        curr.prev=dummyHead;
        dummyHead.next.prev=curr;
        dummyHead.next=curr;
        //在哈希表里加入Dnode
        map.put(curr.key, curr);
    }
    private void moveToHead(Dnode curr) {
        //把curr在链表中去掉
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
        //把curr放到前面
        addDnode(curr);
    }

}








