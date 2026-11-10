package Dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2_generate {
    /*
    要初始化 dp[i][0]=1  dp[i][i]=1
    dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[][]dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0]=1;
            dp[i][i]=1;
        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        //放入集合
        for (int i = 0; i < numRows; i++) {
            List<Integer>list = new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                list.add(dp[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}
