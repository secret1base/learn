package leetcode;

import java.util.Stack;

/**
 * 155.最小栈
 * @author: wyj
 * @date: 2021/05/21
 */
public class A155_MinimumStack {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *  push(x) —— 将元素 x 推入栈中。
     *  pop() —— 删除栈顶的元素。
     *  top() —— 获取栈顶元素。
     *  getMin() —— 检索栈中的最小元素。
     *  示例:
     *  输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    /**
     * 			执行耗时:63 ms,击败了6.77% 的Java用户
     * 			内存消耗:40.5 MB,击败了6.84% 的Java用户
     */
    public static void main(String[] args) {
        A155_MinimumStack minStack = new A155_MinimumStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()==-3);;
        minStack.pop();
        System.out.println(minStack.top()==0);
        System.out.println(minStack.getMin()==-2);;
    }
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
