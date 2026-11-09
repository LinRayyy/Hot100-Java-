package Heap;

import java.util.PriorityQueue;

public class T1_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int n:nums){
            pq.add(n);
        }
        int res=-1;
        for(int i=0;i<k;i++){
            res=pq.poll();
        }
        return res;
    }
}
