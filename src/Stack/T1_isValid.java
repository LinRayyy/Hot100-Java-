package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T1_isValid {
    public boolean isValid(String s) {
        //用栈压入字符，如果是左括号，直接压入，如果是右括号判断是否匹配
        Deque<Character> stack = new ArrayDeque<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) return false;
                if(c=='}'){
                    if(stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
                else if (c==']'){
                    if(stack.peek()=='['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
                else if (c==')'){
                    if(stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
