package leetcode.review;

import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R20_2 {
    public boolean isValid(String s) {
        Stack<Character> path=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='['||c=='('||c=='{'){
                path.push(c);
            }else{
                if(path.isEmpty()){
                    return false;
                }
                Character pop = path.pop();
                if((c==']'&&pop=='[')||(c==')'&&pop=='(')||(c=='}'&&pop=='{')){

                }else{
                    return false;
                }
            }
        }
        return path.isEmpty();
    }
}
