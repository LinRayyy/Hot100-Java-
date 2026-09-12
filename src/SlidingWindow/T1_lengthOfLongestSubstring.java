package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class T1_lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
            if(s==null||s.length()==0) return 0;
            if(s.length()==1) return 1;
            int left=0;
            Set<Character> set=new HashSet<>();
            int maxlen=0;
            for(int right=0;right<s.length();right++) {
                char c=s.charAt(right);
                while(set.contains(c)) set.remove(s.charAt(left++));
                set.add(c);
                maxlen=Math.max(maxlen,right-left+1);
            }
            return maxlen;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
