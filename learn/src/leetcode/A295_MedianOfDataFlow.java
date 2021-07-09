package leetcode;


/**
 * 295. 数据流的中位数
 * @author: wyj
 * @date: 2021/07/09
 */
public class A295_MedianOfDataFlow {
    /** initialize your data structure here. */
    /**
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     *  例如，
     *  [2,3,4] 的中位数是 3
     *  [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *  设计一个支持以下两种操作的数据结构：
     *  void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     *  double findMedian() - 返回目前所有元素的中位数。
     *  示例：
     *  addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     */
    /**
     * 解题思路需要实现一个有序的列表，为了维护有序列表，通过链表形式更便于插入，
     * 在获取中位数时只要知道链表的总体长度即可
     *
     * 不断调试出来的...
     * 			执行耗时:1089 ms,击败了7.41% 的Java用户
     * 			内存消耗:52.2 MB,击败了5.03% 的Java用户
     */
    class MidNode{
        int value;
        MidNode pre;
        MidNode next;

        public MidNode(int value) {
            this.value = value;
        }
    }
    MidNode head;
    int total;
    public A295_MedianOfDataFlow() {
        total=0;
        head=new MidNode(-1);
    }

    public void addNum(int num) {
        if(total==0){
            MidNode midNode = new MidNode(num);
            head.next=midNode;
            midNode.pre=head;
            total++;
        }else{
            MidNode node = head.next;
            //如果是当前值在两个节点之间，插入到中间
            MidNode p=head;
            while (node!=null){
                p=p.next;
                if(node.value<num){
                    //当前值比num小，向后移动
                    node=node.next;
                }else{
                    //当前值大于等于num，插入当前值前面
                    MidNode pre = node.pre;
                    MidNode midNode = new MidNode(num);
                    pre.next=midNode;
                    midNode.pre=pre;
                    midNode.next=node;
                    node.pre=midNode;
                    total++;
                    return;
                }
            }
            if(node==null){
                MidNode midNode = new MidNode(num);
                p.next=midNode;
                midNode.pre=p;
                total++;
            }else{
                //如果没有则放到最后
                MidNode midNode = new MidNode(num);
                node.next=midNode;
                midNode.pre=node;
                total++;
            }
        }
    }

    public double findMedian() {
        int mid = total / 2;
        //0123 /2 =2 mid-1 mid
        //01234 /2=2 mid
        //找到mid
        MidNode node = head.next;
        //找到mid
        for (int i = 0; i < mid; i++) {
            node=node.next;
        }
        if(total%2==0){
            return (node.pre.value+node.value)/2.0;
        }else{
            return node.value;
        }
    }

    public static void main(String[] args) {
        A295_MedianOfDataFlow a = new A295_MedianOfDataFlow();
        a.addNum(1);
        a.addNum(2);
        a.addNum(3);
        System.out.println(a.findMedian());
    }
}
