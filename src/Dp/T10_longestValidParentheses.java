package Dp;

public class T10_longestValidParentheses {
    public int longestValidParentheses(String s) {
        //dp[i]表示以i结尾的合法括号长度
        int[]dp=new int[s.length()];
        int maxLen=0;
        //如果是( 直接跳过
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')') {
                //如果是)，分两种情况，第一种情况i-1是( 那就是dp[i]=dp[i-2]+2
                if(s.charAt(i-1)=='(') {
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }
                else if((i-dp[i-1])>0&&s.charAt(i-dp[i-1]-1)=='(') {
                    int prev=(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                    //如果是） pos=i-dp[i-1]-1
                    //如果pos是( dp[i]=dp[i-1]+1
                    //找前置prev,防止漏掉前面紧贴的合法括号长度
                    dp[i]=dp[i-1]+2+prev;
                }
                }
            maxLen = Math.max(maxLen, dp[i]);
            }
        return maxLen;
        }
    }

