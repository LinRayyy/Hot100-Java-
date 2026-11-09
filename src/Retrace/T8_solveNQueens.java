package Retrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T8_solveNQueens {
    private boolean[]col;
    private boolean[]diag1;
    private boolean[]diag2;
    private char[][] board;
    private List<List<String>> res=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];//记录列
        diag1 = new boolean[2*n-1];//记录主对角线
        diag2 = new boolean[2*n-1];//记录副对角线
        board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        retrace(n,0);
        return res;
    }

    public void retrace(int n,int row) {
        //如果row==n,则往res中加入对应数据
        if(row==n){
            List<String> list=new ArrayList<>();
            for(char[]b:board)list.add(new String(b));
            res.add(list);
            return;
        }
        //进入row+1之前，先判断列 主对角线 副对角线
        //满足条件，更改char值，进入下一个，然后回溯char
        for(int c=0;c<n;c++){
            int d1 = row - c + n - 1;
            int d2 = row + c;
            if(col[c]||diag1[d1]||diag2[d2])continue;
            col[c]=diag1[d1]=diag2[d2]=true;
            board[row][c]='Q';
            retrace(n,row+1);
            col[c]=diag2[d2]=diag1[d1]=false;
            board[row][c]='.';
        }
    }
}
