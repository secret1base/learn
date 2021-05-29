package leetcode.review;

import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R20_1 {
    /**
     * 			执行耗时:2 ms,击败了78.18% 的Java用户
     * 			内存消耗:36.6 MB,击败了45.71% 的Java用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //(){}[]
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                boolean flag=false;
                if((c==']'&&pop=='[')||(c=='}'&&pop=='{')||(c==')'&&pop=='(')){
                    flag = true;
                }
                if(!flag){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
