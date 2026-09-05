package DoublePointer;

public class T2_maxArea {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<=right) {
            int maxHeight = Math.min(height[left],height[right]);
            max = Math.max(max,maxHeight*(right-left));
            if(height[left]<height[right]) {
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
