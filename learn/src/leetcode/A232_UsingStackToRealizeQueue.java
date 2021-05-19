package leetcode;

import java.util.Stack;

/**
 * 232.用栈实现队列
 * @author: wyj
 * @date: 2021/05/17
 */
public class A232_UsingStackToRealizeQueue {
    /**
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     *  实现 MyQueue 类：
     *  void push(int x) 将元素 x 推到队列的末尾
     *  int pop() 从队列的开头移除并返回元素
     *  int peek() 返回队列开头的元素
     *  boolean empty() 如果队列为空，返回 true ；否则，返回 false
     *  说明：
     *  你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     *  你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     *  进阶：
     *  你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
     *  示例：
     * 输入：
     * ["MyQueue", "push", "push", "peek", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 1, 1, false]
     * 解释：
     * MyQueue myQueue = new MyQueue();
     * myQueue.push(1); // queue is: [1]
     * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
     * myQueue.peek(); // return 1
     * myQueue.pop(); // return 1, queue is [2]
     * myQueue.empty(); // return false
     *  提示：
     *  1 <= x <= 9
     *  最多调用 100 次 push、pop、peek 和 empty
     *  假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
     */
    /**
     * 题目本身实现简单，需要注意思路是通过两个栈来进行实现
     */
    Stack<Integer> head=new Stack<> ();
    Stack<Integer> que=new Stack<> ();
    /** 将元素 x 推到队列的末尾  */
    public void push(int x) {
        //每次放元素，先将que栈中的元素放入head中(在放置前head为空)
        while (!que.isEmpty()){
            head.push(que.pop());
        }
        //接着将当前元素放入head中
        head.push(x);
        //这时将head(先进后出)中的元素放入que中,那么que中元素顺序为最先放的元素在que的栈顶，下次pop时，从que的栈顶取元素即可
        while (!head.isEmpty()){
            que.push(head.pop());
        }
    }

    /** 从队列的开头移除并返回元素  */
    public int pop() {
        return que.pop();
    }

    /** 返回队列开头的元素 */
    public int peek() {
        return que.peek();
    }

    /** 如果队列为空，返回 true ；否则，返回 false  */
    public boolean empty() {
        return que.empty();
    }
}
