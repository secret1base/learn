package leetcode.review;

import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R155_4 {
    Stack<Integer> head=new Stack<>();
    Stack<Integer> right=new Stack<>();
    public void push(int val) {
        head.push(val);
        if(right.isEmpty()){
            right.push(Integer.MAX_VALUE);
        }
        right.push(Math.min(val,right.peek()));
    }
    public void pop() {
        right.pop();
        head.pop();
    }
    public int top(){
        return head.peek();
    }
    public int getMin(){
        return right.peek();
    }
}
