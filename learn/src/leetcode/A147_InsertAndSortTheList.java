package leetcode;

import leetcode.tool.ListNode;

/**
 * 147. 对链表进行插入排序
 * @author: wyj
 * @date: 2021/07/27
 */
public class A147_InsertAndSortTheList {
    /**
     * 对链表进行插入排序。
     * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
     * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
     *  插入排序算法：
     *  插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     *  每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     *  重复直到所有输入数据插入完为止。
     *  示例 1：
     *  输入: 4->2->1->3
     * 输出: 1->2->3->4
     *  示例 2：
     *  输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     *
     * 废了点心思
     * 			执行耗时:25 ms,击败了25.41% 的Java用户
     * 			内存消耗:37.9 MB,击败了81.44% 的Java用户
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode pre=new ListNode();
        ListNode node=head;
        while (node!=null){
            ListNode tmpPre=pre;
            if(tmpPre.next==null){
                tmpPre.next=node;
                ListNode next = node.next;
                node.next=null;
                node=next;
            }else{
                while (true){
                    ListNode next = tmpPre.next;
                    if(next==null){
                        tmpPre.next=node;
                        ListNode after = node.next;
                        node.next=null;
                        node=after;
                        break;
                    }else if(next.val<node.val){
                        tmpPre=tmpPre.next;
                    }else{
                        ListNode after = tmpPre.next;
                        ListNode newNode = node.next;
                        tmpPre.next=node;
                        node.next=after;
                        node=newNode;
                        break;
                    }
                }

            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(3);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        ListNode listNode = new A147_InsertAndSortTheList().insertionSortList(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
