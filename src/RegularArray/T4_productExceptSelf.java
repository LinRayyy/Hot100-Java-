package RegularArray;

public class T4_productExceptSelf {
    /*
    用front[i]记录前i个元素乘积 back[i]记录索引i后面的所有元素乘积
    answer[i]=front[i]*back[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[]ans=new int[n];
        int[]front=new int[n];
        int[]back=new int[n];
        front[0]=1;back[n-1]=1;
        for(int i=1;i<n;i++)front[i]=front[i-1]*nums[i-1];
        for(int i=n-2;i>=0;i--)back[i]=back[i+1]*nums[i+1];
        for(int i=0;i<n;i++)ans[i]=front[i]*back[i];
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int[] ans=productExceptSelf(nums);
        for(int n:ans)System.out.print(n+" ");
    }
}
