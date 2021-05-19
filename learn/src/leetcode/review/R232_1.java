package leetcode.review;


import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R232_1 {
    Stack<Integer> left=new Stack<> ();
    Stack<Integer> right=new Stack<>();
    // void push(int x) 将元素 x 推到队列的末尾
    public void push(int x){
        //通过两个先进后出，实现一个先进先出
        //把right中放的导入left中
        while (!right.isEmpty()){
            //right中存放的是321，出栈是123
            left.push(right.pop());
        }
        left.push(x);
        //left存放1234
        while (!left.isEmpty()){
            right.push(left.pop());
        }
    }
    // int pop() 从队列的开头移除并返回元素
    public int pop(){
        return right.pop();
    }
    // int peek() 返回队列开头的元素
    public int peek(){
        return right.peek();
    }
    // boolean empty() 如果队列为空，返回 true ；否则，返回 false
    public boolean empty(){
        return right.isEmpty();
    }
}
