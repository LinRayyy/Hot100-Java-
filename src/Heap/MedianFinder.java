package Heap;

import java.util.PriorityQueue;

public class MedianFinder {
    /*
    用两个优先队列实现查找中位数，一个存储左边较小的一半，另一个存储右边较小的一个
     */
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //优先存在左边
        if(left.isEmpty()||num<left.peek()){
            left.add(num);
        }else{
            right.add(num);
        }
        //平衡两个优先队列的元素数量
        if(left.size()-right.size()>1){
            right.add(left.poll());
        }
        if(right.size()>left.size()){
            left.add(right.poll());
        }
    }

    public double findMedian() {
        //如果是奇数，直接放回left顶部元素
        if(left.size()>right.size()){
            return left.peek();
        }else{
            //如果是偶数，则两个数的平均值
            return (left.peek()+right.peek())/2.0;
        }
    }
}
