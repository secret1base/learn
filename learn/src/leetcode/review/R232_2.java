package leetcode.review;


import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R232_2 {
    //请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
// 实现 MyQueue 类：
//
//
    Stack<Integer> left=new Stack<>();
    Stack<Integer> right=new Stack<>();//倒放
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
//  返回队列开头的元素
//  如果队列为空，返回 true ；否则，返回 false
}
