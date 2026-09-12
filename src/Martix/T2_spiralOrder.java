package Martix;

import java.util.ArrayList;
import java.util.List;

public class T2_spiralOrder {
    /*
    从第0行第0列个元素开始往右遍历，将元素放进集合中，并置-1000
    先右再下再左再上
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int has_found=-1000;
        int n=matrix.length;
        int m=matrix[0].length;
        int count=0;
        List<Integer> list=new ArrayList<>();
        list.add(matrix[0][0]);
        matrix[0][0]=has_found;
        int r=0,c=0;
        count++;
        while(count<m*n){
            int a=1;
            //向右
            while((c+1)<m&&matrix[r][c+1]!=has_found){
                c++;
                list.add(matrix[r][c]);
                matrix[r][c]=has_found;
                count++;
            }
            //向下
            while((r+1)<n&&matrix[r+1][c]!=has_found){
                r++;
                list.add(matrix[r][c]);
                matrix[r][c]=has_found;
                count++;
            }
            //向左
            while((c-1)>=0&&matrix[r][c-1]!=has_found){
                c--;
                list.add(matrix[r][c]);
                matrix[r][c]=has_found;
                count++;
            }
            //向上
            while((r-1)>=0&&matrix[r-1][c]!=has_found){
                r--;
                list.add(matrix[r][c]);
                matrix[r][c]=has_found;
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer>l=spiralOrder(matrix);
        String s=l.toString();
        System.out.println(s);
    }
}
