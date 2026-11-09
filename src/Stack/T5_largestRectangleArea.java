package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T5_largestRectangleArea {
    //最大面积思路：单调减小栈
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack=new ArrayDeque<>();
        //从头开始遍历
        int maxArea=0;
        //利用单调栈，找到第一个比自己小的数字a，然后计算面积，长是原数字-小数字位置；宽就是原数字大小
        for(int i=0;i<heights.length;i++){
                while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                    int index=stack.pop();
                    int height=heights[index];
                    int left=stack.isEmpty()?-1:stack.peek();
                    int width=i-left-1;
                    maxArea=Math.max(maxArea,width*height);
                }
                stack.push(i);
            }
        // 循环走完，栈里还有元素：它们的右边界都是 n
         while (!stack.isEmpty()) {
            int idx = stack.pop();
            int h = heights[idx];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = heights.length - left - 1;
            maxArea = Math.max(maxArea, h * width);
        }
        return maxArea;
        }



    public static void main(String[] args) {
        T5_largestRectangleArea obj=new T5_largestRectangleArea();
        int[]heights ={2,1,5,6,2,3};
        System.out.println(obj.largestRectangleArea(heights));
    }
}
