package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * @author: wyj
 * @date: 2021/06/18
 */
public class A225_UsingQueueToRealizeStack {
    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
     *  实现 MyStack 类：
     *  void push(int x) 将元素 x 压入栈顶。
     *  int pop() 移除并返回栈顶元素。
     *  int top() 返回栈顶元素。
     *  boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     *  注意：
     *  你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
     *  你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     *  示例：
     * 输入：
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 2, 2, false]
     * 解释：
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // 返回 2
     * myStack.pop(); // 返回 2
     * myStack.empty(); // 返回 False
     *
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.9 MB,击败了92.01% 的Java用户
     */
    public A225_UsingQueueToRealizeStack() {

    }
    Queue<Integer> pre=new LinkedList<>();//12345
    Queue<Integer> after=new LinkedList<>();//54321
    /**
     * 栈后进先出，队列先进先出
     */

    /** Push element x onto stack. */
    public void push(int x) {
        pre.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (!pre.isEmpty()){
            Integer poll = pre.poll();
            if(pre.isEmpty()){
                pre=after;
                after=new LinkedList<> ();
                return poll;
            }else{
                after.offer(poll);
            }
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        while (!pre.isEmpty()){
            Integer poll = pre.poll();
            after.offer(poll);
            if(pre.isEmpty()){
                pre=after;
                after=new LinkedList<> ();
                return poll;
            }
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return pre.isEmpty();
    }

    public static void main(String[] args) {
        A225_UsingQueueToRealizeStack a = new A225_UsingQueueToRealizeStack();
        a.push(1);
        a.push(2);
        a.push(3);
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}
