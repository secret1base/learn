package leetcode.review;

import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R20_3 {
    /**
     * 			执行耗时:2 ms,击败了78.36% 的Java用户
     * 			内存消耗:36.7 MB,击败了40.99% 的Java用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> path=new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='['||c=='{'||c=='('){
                path.push(c);
            }else{
                if(path.isEmpty()){
                    return false;
                }else{
                    Character pop = path.pop();
                    if((c==']'&&pop=='[')||(c=='}'&&pop=='{')||(c==')'&&pop=='(')){

                    }else{
                        return false;
                    }
                }
            }
        }
        return path.isEmpty();
    }
}
