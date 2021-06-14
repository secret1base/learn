package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R20_4 {
    //			执行耗时:2 ms,击败了78.58% 的Java用户
    //			内存消耗:36.4 MB,击败了83.11% 的Java用户
    public boolean isValid(String s) {
        Deque<Character> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='['||c=='('||c=='{'){
                path.offerLast(c);
            }else{
                if(path.isEmpty()){
                    return false;
                }
                Character character = path.pollLast();
                if(c==']'&&character!='['){
                    return false;
                }
                if(c=='}'&&character!='{'){
                    return false;
                }if(c==')'&&character!='('){
                    return false;
                }
            }
        }
        return path.size()==0;
    }
}
