package Greedy;

import java.util.ArrayList;
import java.util.List;

public class T4_partitionLabels {
    /*
    维护一个字符最后出现位置的数组
    用一个right去维护有边界
    若这个字符串可以被切，说明当前字符串里的所有字符的最远索引都小于右边界
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[]last=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        //开始判断
        int end=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,last[s.charAt(i)-'a']);
            if(end==i){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}
