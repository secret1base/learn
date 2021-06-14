package leetcode.review;


import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R232_4 {
    Stack<Integer> head=new Stack<>();
    Stack<Integer> right=new Stack<>();
    public void push(int x){
        while (!right.isEmpty()){
            head.push(right.pop());
        }
        head.push(x);
        while (!head.isEmpty()){
            right.push(head.pop());
        }
    }
    public int pop() {
        return right.pop();
    }
    public int peek() {
        return right.peek();
    }
    public boolean empty() {
        return right.empty();
    }
}
