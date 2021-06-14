package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R227_2 {
    public int calculate(String s) {
        int num=0;
        Character pre='+';
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }else if(c!=' '){
                if(pre =='+'){
                    path.offerLast(num);
                }else if(pre=='-'){
                    path.offerLast(-num);
                }else if(pre=='*'){
                    path.offerLast(path.pollLast()*num);
                }else if(pre=='/'){
                    path.offerLast(path.pollLast()/num);
                }
                num=0;
                pre=c;
            }
        }
        if(pre =='+'){
            path.offerLast(num);
        }else if(pre=='-'){
            path.offerLast(-num);
        }else if(pre=='*'){
            path.offerLast(path.pollLast()*num);
        }else if(pre=='/'){
            path.offerLast(path.pollLast()/num);
        }
        int sum=0;
        for (Integer integer : path) {
            sum+=integer;
        }
        return sum;
    }
}
