package leetcode;

import java.util.Stack;

/**
 * 剑指 Offer 09.用两个栈实现队列
 * @author: wyj
 * @date: 2021/06/16
 */
public class A10009_UsingTwoStacksToImplementQueue {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
     * 功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *  示例 1：
     *  输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     *  示例 2：
     *  输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     * 			执行耗时:306 ms,击败了6.49% 的Java用户
     * 			内存消耗:46.4 MB,击败了84.65% 的Java用户
     */
    public A10009_UsingTwoStacksToImplementQueue() {

    }
    Stack<Integer> left=new Stack<>();
    Stack<Integer> right=new Stack<>();
    public void appendTail(int value) {
        while (!left.isEmpty()){//54321
            right.push(left.pop());
        }
        right.push(value);//123456
        while (!right.isEmpty()){//654321
            left.push(right.pop());
        }

    }

    public int deleteHead() {
        return left.isEmpty()?-1:left.pop();
    }

    public static void main(String[] args) {
        A10009_UsingTwoStacksToImplementQueue a = new A10009_UsingTwoStacksToImplementQueue();
        a.appendTail(1);
        a.appendTail(2);
        a.appendTail(3);
        System.out.println(a.deleteHead());
        System.out.println(a.deleteHead());
        System.out.println(a.deleteHead());
    }
}
