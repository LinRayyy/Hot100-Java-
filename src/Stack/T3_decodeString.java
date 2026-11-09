package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T3_decodeString {
    /*
    字符串解码思路：正序双栈
     */
    public String decodeString(String s) {
        //定义两个栈存储字符串，一个存储数字，stackStr存储临时字符串 stackNum存储现在数值
        Deque<Integer> stackNum = new ArrayDeque<>();
        Deque<String> stackStr = new ArrayDeque<>();
        int num=0;
        StringBuilder curStr = new StringBuilder();
        for(char c : s.toCharArray()) {
            //如果字符是数字，则原数字乘10——它
            if(Character.isDigit(c)) {
                num=num*10+c-'0';
            }else if(c=='[') {
                //如果是左括号，压入stackStr stackNum并初始化
                stackNum.push(num);
                stackStr.push(curStr.toString());
                num=0;
                curStr=new StringBuilder();
            }else if(c==']') {
            //如果是右括号，弹出对应字符串和数字，并进行拼接
                String temp=stackStr.pop();
                StringBuilder curStr2=new StringBuilder(temp);
                int tempNum=stackNum.pop();
                for(int i=0;i<tempNum;i++) {
                    curStr2.append(curStr);
                }
                curStr=curStr2;
            }else {
                //如果是字符，直接加进字符串
                curStr.append(c);
            }
        }
        return curStr.toString();
    }

    public static void main(String[] args) {
        T3_decodeString test = new T3_decodeString();
        System.out.println(test.decodeString("3[a2[c]]"));
    }
}
