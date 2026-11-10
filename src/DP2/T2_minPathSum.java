package DP2;

public class T2_minPathSum {
    public int minPathSum(int[][] grid) {
        //dp[i][j]表示(0,0)到（i,j）的最短距离
        int m = grid.length;
        int n = grid[0].length;
        int[][]dp=new int[m][n];
        //初始化第一列和第一行的值
        for(int i=0;i<m;i++){
            dp[i][0]=(i-1>=0?dp[i-1][0]:0)+grid[i][0];
        }
        for(int j=0;j<n;j++){
            dp[0][j]=(j-1>=0?dp[0][j-1]:0)+grid[0][j];
        }
        //d[i][j]=Math.min(dp[i-1][j],dp[i][j-1])
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
