package DP2;

public class T5_minDistance {
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示word1前i个字符变成word2前j个字符需要的最小操作数
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        //初始化
        for (int i = 0; i <=n; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=m; i++) {
            dp[0][i]=i;
        }
        //字符相等 dp[i][j]=dp[i-1][j-1]
        //删除字符 dp[i][j]=dp[i-1][j]+1
        //替换字符 dp[i][j]=dp[i-1][j-1]+1
        //插入字符 dp[i][j]=dp[i][j-1]+1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j -1] ;
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[n][m];
    }
}
