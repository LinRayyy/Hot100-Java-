package Martix;

public class T4_searchMatrix {
    /*
    1.先按行向下遍历，直到该元素的下个元素大于target
    2.然后按列往右遍历，直到下一个元素大于或等于target
    3.如果等于，直接输出true,大于重复1，2操作，直到行数小于0；输出false;

     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r=-1;
        int c=0;
        int n = matrix.length;
        int m = matrix[0].length;
        //寻找第一个比target小的行数
        for(int i=0;i<n;i++){
            if(matrix[i][0]==target)return true;
            else if(matrix[i][0]<target)r=i;
        }
        if(r==-1)return false;
        while(r>=0){
            //开始遍历列数
            while(c<m){
                if(matrix[r][c]==target)return true;
                else if(matrix[r][c]<target)c++;
                else if(matrix[r][c]>target)break;
            }
            r--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][]matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,4));
    }
}
