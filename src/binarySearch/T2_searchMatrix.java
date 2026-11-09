package binarySearch;

public class T2_searchMatrix {
    /*
    * 一次性二分 left=0 right=m*n-1
    * 每一个序号对应的坐标是  col=index%(m-1) row=index/(m-1)
    *
    * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left=0;
        int right=m*n-1;
        while(left<=right){
            int mid=(left+right)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target)return true;
            else if(matrix[row][col]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
}
