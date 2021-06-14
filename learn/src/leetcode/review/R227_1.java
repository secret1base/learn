package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R227_1 {
    //输入：s = "3+2*2"
//输出：7
// 示例 2：
//输入：s = " 3/2 "
//输出：1
// 示例 3：
//输入：s = " 3+5 / 2 "
//输出：5
    //			执行耗时:14 ms,击败了69.52% 的Java用户
    //			内存消耗:41.8 MB,击败了15.41% 的Java用户
    public int calculate(String s) {
        Deque<Integer> path=new LinkedList<>();
        int num=0;
        Character pre='+';
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }else if(c!=' '){
                //即为符号
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
        if(pre=='+'){
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

    public static void main(String[] args) {
        int calculate = new R227_1().calculate(" 3+5 / 2 ");
        System.out.println(calculate);
    }
}
