package leetcode.review;


import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R155_5 {
    //			执行耗时:7 ms,击败了81.53% 的Java用户
    //			内存消耗:40.1 MB,击败了65.83% 的Java用户
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public void push(int val) {
        if(minStack.isEmpty()){
            minStack.push(Integer.MAX_VALUE);
        }
        stack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
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

    public static void main(String[] args) {
        R155_5 r155_5 = new R155_5();
        r155_5.push(-1);
        r155_5.top();
        System.out.println(r155_5.getMin());
    }
}
