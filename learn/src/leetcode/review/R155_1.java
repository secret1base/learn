package leetcode.review;


import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R155_1 {
    //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(Integer.MAX_VALUE);
        }
        minStack.push(Math.min(val,minStack.peek()));
    }
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
