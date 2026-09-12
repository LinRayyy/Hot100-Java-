package Substring;


public class T3_minWindow {
    /*
    1。先用tCount记录t每个字符出现的次数，用sa记录t中含有的不同字符的数量，用ds记录窗口中"数量已满足"的字符种类数
    2.right从索引0开始遍历，s中所有字符都计入pCount（非t字符的tCount为0），当pCount[c]==tCount[c]时ds++
    3.ds==sa说明窗口已经覆盖了t的所有字符，此时开始收缩left：只要pCount[left]>tCount[left]就可以右移
    4.每收缩一步就更新最短长度和起止索引；收缩到窗口不再合法（ds<sa）时退出，继续移动right
     */
    public static String minWindow(String s, String t) {
        if(t.length()>s.length())return "";
        int[]tCount=new int[128];
        int[]pCount=new int[128];
        int sa=0;
        int ds=0;
        for(char c:t.toCharArray()){
            if(tCount[c]==0)sa++;
            tCount[c]++;
        }
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int l=0;
        int r=-1;
        for(int right=0;right<s.length();right++){
            char rc=s.charAt(right);
            //所有字符都进pCount，非t字符的tCount是0，收缩时会自然被跳过
            pCount[rc]++;
            //刚好满足需求时ds才+1，多余的字符不影响ds
            if(pCount[rc]==tCount[rc])ds++;

            //已经包含所有t的字符，开始收缩子串
            while(ds==sa){
                //此时窗口合法，先比较长度，再记录索引
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    l=left;
                    r=right;
                }
                //left右移，移出的字符数量不够了ds才-1
                char lc=s.charAt(left);
                pCount[lc]--;
                if(pCount[lc]<tCount[lc])ds--;
                left++;
            }
        }
        //返回长度
        return r==-1?"":s.substring(l,r+1);
    }

    public static void main(String[] args) {
        String s="aaaaaaaaaaaabbbbbcdd";
        String t="abcdd";
        System.out.println(minWindow(s,t));

        System.out.println(minWindow("aaab","ab"));
        System.out.println(minWindow("aaab","aab"));
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
