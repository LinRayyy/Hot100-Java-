package Martix;

public class T3_rotateMatrix {
    /*
    矩阵旋转思路：旋转可以由翻折得到，顺时针旋转90度=对角线翻折＋每列上下翻转
    具体实现：1.先沿着对角线翻折，交换元素
            2.每列上下翻折，交换元素
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //实现对角线翻折
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][m-i-1];
                matrix[n-j-1][m-i-1] = temp;
            }
        }

        //实现每一列对折
        for(int j=0;j<m;j++){
            for(int i=0;i<n/2;i++){
                int temp = matrix[n-i-1][j];
                matrix[n-i-1][j]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][]matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
