package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
前k个高频元素
 */
public class T2_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
            if (pq.size() > k) {
                pq.poll(); // 超过k，把频次最小的踢出去
            }
        }
        int[] res = new int[k];
        for(int i=k-1;i>=0;i--){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
