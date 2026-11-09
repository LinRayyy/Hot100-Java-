package Retrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T3_letterCombinations {

    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length() == 0) return res;
        List<Character>path=new ArrayList<>();
        dfs(digits,0,path,res);
        return res;
    }

    private void dfs(String digits,int index,List<Character> path,List<String> res){
        if(index==digits.length()){
            // path拼成字符串
            StringBuilder sb = new StringBuilder();
            for(char ch : path){
                sb.append(ch);
            }
            res.add(sb.toString());
            return;  // 【关键！】收集完立刻返回，不再往下执行charAt
        }
        //对于每一位，通过map[digit.charAt(index)-'0']获取对应可能的数字组合
        String letters=map[digits.charAt(index)-'0'];
        //加入字符 回溯 删除字符
        for(char c:letters.toCharArray()){
            path.add(c);
            dfs(digits,index+1,path,res);
            path.remove(path.size()-1);
        }
    }
}
