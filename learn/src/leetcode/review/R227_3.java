package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R227_3 {
    //			执行耗时:14 ms,击败了69.52% 的Java用户
    //			内存消耗:41.7 MB,击败了24.37% 的Java用户
    public int calculate(String s) {
        int num=0;
        Character pre='+';
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }else if(c!=' '){
                if(pre=='+'){
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
        if(num!=0){
            if(pre=='+'){
                path.offerLast(num);
            }else if(pre=='-'){
                path.offerLast(-num);
            }else if(pre=='*'){
                path.offerLast(path.pollLast()*num);
            }else if(pre=='/'){
                path.offerLast(path.pollLast()/num);
            }
        }
        int sum=0;
        for (Integer integer : path) {
            sum+=integer;
        }
        return sum;
    }
}
