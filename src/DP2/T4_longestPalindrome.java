package DP2;

public class T4_longestPalindrome {
    public String longestPalindrome(String s) {
        //中心拓展法解决回文字符串
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;
        int maxlen=1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //先获取两种回文的最大值
            int l1=getLen(s,i,i);
            int l2=getLen(s,i,i+1);
            //比较长度，选最长的结果，然后和最大值比较
            int l3=Math.max(l1,l2);
            if(l3>maxlen){
                maxlen=l3;
                start=i-(maxlen-1)/2;
                end=i+maxlen/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int getLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //left right多走了一步
        return right - left - 1;
    }

    //二维dp解决
    public String longestPalindrome2(String s){
        //dp[i][j]表示以i开始,j结尾的字符串是不是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化dp[i][i]=true;
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        //先遍历长度，i从0开始遍历，再推出j
        int maxlen=1;
        int start = 0;
        int end = 0;
        for(int Len=2;Len<s.length();Len++) {
            for(int i=0;i+Len-1<s.length();i++) {
                int j=i+Len-1;
                //如果i j字符相等，dp[i][j]=dp[i+1][j-1]
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<3)dp[i][j]=true;
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j]) {
                            if (Len > maxlen) {
                                maxlen = Len;
                                start = i;
                                end = j;
                            }
                        }
                    }
                }
                //如果dp[i][j]=true; 更新长度
            }
        }
        return s.substring(start,end+1);
    }
}
