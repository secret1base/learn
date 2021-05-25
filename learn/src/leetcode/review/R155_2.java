package leetcode.review;

import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R155_2 {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(Integer.MAX_VALUE);
        }
        minStack.push(Math.min(minStack.peek(),val));
    }
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
