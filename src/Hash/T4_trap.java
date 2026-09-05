package Hash;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class T4_trap {



    /*
    双指针做法
    1.决定某一个格子的蓄水量，是由左右两边第一个比自己高的柱子决定的
    2.(1)利用木桶效应，先从索引为0和length-1的地方开始，找到最大的柱子，作为最大的木板
      (2)然后从小木板那一侧，开始向中间判断格子蓄水量，可以算出在当前这个小木板下，这个位置的蓄水量
      (3)然后继续往中间找木板，补充其它高度的蓄水量
     */
    public static int trap(int[] height) {
        int left=0;int right=height.length-1;
        int Lmax=height[left];int Rmax=height[right];
        int res=0;
        while(left<right) {
            Lmax=Math.max(Lmax,height[left]);
            Rmax=Math.max(Rmax,height[right]);
            if(Lmax<Rmax) {
                res+=(Lmax-height[left]);
                left++;
            }
            else {
                res+=(Rmax-height[right]);
                right--;
            }
        }
        return res;
    }

    /*
    单调栈
    用deque存入单调递减的高度高度
    灵活应用peek()和poll()
     */
    public static int trap_next(int[] height) {
        Deque<Integer>stack=new ArrayDeque<>();
        int res=0;
        for(int i=0;i<height.length;i++) {
            while(!stack.isEmpty() && height[stack.peek()]<height[i]) {
                int mid=stack.pop();
                if(stack.isEmpty())break;
                int left=stack.peek();
                int h=Math.min(height[left],height[i])-height[mid];
                int w=i-left-1;
                res+=(h*w);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]heights={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap_next(heights));
    }
}
