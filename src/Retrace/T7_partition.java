package Retrace;

import java.util.ArrayList;
import java.util.List;

public class T7_partition {
    public List<List<String>> partition(String s) {
        //先判断哪些子串是dp
        List<List<String>> res = new ArrayList<List<String>>();
        boolean[][]dp = new boolean[s.length()][s.length()];
        List<String>path=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)&&((i-j<=2)||(dp[j+1][i-1])))dp[j][i]=true;
            }
        }
        //然后从序号start开始遍历，end++ 如果dp[start][end]是回文子串，就把他加入path
        retrace(s,0,res,path,dp);
        //当序号==s.length,将path放入res中
        return res;
    }

    public void retrace(String s,int start,List<List<String>> res,List<String>path,boolean[][]dp) {
        if(start==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(dp[start][end]){
                path.add(s.substring(start,end+1));
                retrace(s,end+1,res,path,dp);
                path.remove(path.size()-1);
            }
        }
    }




}
