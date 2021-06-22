package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * @author: wyj
 * @date: 2021/06/18
 */
public class A138_CopyLinkedListWithRandomPointer {
    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     *  构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
     * 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     *  例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random
     * --> y 。
     *  返回复制链表的头节点。
     *  用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     *  val：一个表示 Node.val 的整数。
     *  random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
     *  你的代码 只 接受原链表的头节点 head 作为传入参数。
     *  示例 1：
     *  138(1).png
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     *  示例 2：
     *  138(2).png
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     *  示例 3：
     *  138(3).png
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     *  示例 4：
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     * @param head
     * @return
     */
    /**
     * 题目看的人莫名其妙的，其实只是单纯的复制一个随机链表,这道题就是读题烦了点
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.1 MB,击败了58.28% 的Java用户
     * @param head
     * @return
     */
    public RandomNode copyRandomList(RandomNode head) {
        RandomNode node=head;
        Map<RandomNode,RandomNode> map=new HashMap<>();
        RandomNode newHead=null;
        RandomNode newNode=null;
        while (node!=null){
            RandomNode randomNode = new RandomNode(node.val);
            if(newHead==null){
                newHead=randomNode;
                newNode=newHead;
            }else{
                newNode.next=randomNode;
                newNode=newNode.next;
            }
            map.put(node,randomNode);
            node=node.next;
        }
        node=head;
        newNode=newHead;
        while (node!=null){
            RandomNode randomNode = map.get(node.random);
            newNode.random=randomNode;
            node=node.next;
            newNode=newNode.next;
        }
        return newHead;
    }
}
class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}