package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class T4_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[]answer=new int[temperatures.length];
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<temperatures.length;i++){
            if(stack.isEmpty()||temperatures[i]<temperatures[stack.peek()])stack.push(i);
            else{
                while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                    int index=stack.pop();
                    answer[index]=i-index;
                }
                stack.push(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        T4_dailyTemperatures obj=new T4_dailyTemperatures();
        int[]num={73,74,75,71,69,72,76,73};
        int[] ans=obj.dailyTemperatures(num);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
