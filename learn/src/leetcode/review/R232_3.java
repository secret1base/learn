package leetcode.review;


import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/06/02
 */
public class R232_3 {
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.4 MB,击败了38.95% 的Java用户
     */
    Stack<Integer> left=new Stack<>();
    Stack<Integer> right=new Stack<>();
    void push(int x){
        while (!right.isEmpty()){
            left.push(right.pop());
        }
        left.push(x);
        while (!left.isEmpty()){
            right.push(left.pop());
        }
    }
    int pop(){
        return right.pop();
    }

    int peek(){
        return right.peek();
    }
    boolean empty(){
        return right.empty();
    }
}
