package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2_findAnagrams {
    /*
    1.检验：先比较p,s的长度，如果不符合，直接返回
    2。初始化：先判断第一个窗口，方便后面操作
    3.定义两个数组，统计窗口s,p各个字符的数量
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int lenS=s.length();int lenP=p.length();
        if(lenS<lenP)return ans;
        int[]sCount=new int[26];
        int[]pCount=new int[26];
        for(int i=0;i<lenP;i++){
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }
        System.out.println("sCount:"+Arrays.toString(sCount));
        System.out.println("pCount:"+Arrays.toString(pCount));
        if(Arrays.equals(sCount,pCount))ans.add(0);
        for(int i=lenP;i<lenS;i++){
            int start=i;
            int end=start-lenP;
            sCount[s.charAt(start)-'a']++;
            sCount[s.charAt(end)-'a']--;
            if(Arrays.equals(sCount,pCount)){
                ans.add(end+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="cbaebabacd";
        String p="abc";
        List<Integer> ans=findAnagrams(s, p);
        for(Integer i:ans)System.out.print(i+" ");
    }
}
