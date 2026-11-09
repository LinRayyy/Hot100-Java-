package Retrace;

import java.util.ArrayList;
import java.util.List;

public class T5_generateParenthesis {
    //核心：右括号小于等于左括号
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder(n);
        dfs(n,0,0,path,res);
        return res;
    }

    public void dfs(int n,int left,int right,StringBuilder path,List<String> res){
        //如果左括号和右括号的数量都等于n，将path添加进res
        if(left==n && right==n){
            res.add(path.toString());
            return;
        }
        //优先添加左括号，进行回溯
        if(left<n){
            path.append('(');
            dfs(n,left+1,right,path,res);
            path.deleteCharAt(path.length()-1);
        }
        //再添加右括号，如果此时右括号数量大于左括号，跳过
        if(right<left){
            path.append(')');
            dfs(n,left,right+1,path,res);
            path.deleteCharAt(path.length()-1);
        }
    }
}
