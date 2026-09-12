package RegularArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2_merge {
    /*
    1.先将所有的区间按照左边界从小到大开始排序
    2.贪心策略：左边界最小（A区间）的开始寻找，如果旁边B区间左边界小于等于A右边界，则可以合并
     */
    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][];
        }
        //a[0]-b[0]可能溢出，用Integer.compare更稳
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=new ArrayList<>();
        //当前正在合并的区间，初始为第一个区间
        int left=intervals[0][0];
        int right=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>right){
                //后一个区间的左边界比当前右边界还大，接不上，结算当前区间
                list.add(new int[]{left,right});
                //开启新的一段
                left=intervals[i][0];
                right=intervals[i][1];
            }
            else{
                //能接上，右边界取两者的最大值（注意可能被包含，所以不能直接赋值）
                right=Math.max(right,intervals[i][1]);
            }
        }
        //最后一段别忘了加
        list.add(new int[]{left,right});
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][]intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][]ans=merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }
}
