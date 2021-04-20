package leetcode.tool;

/**
 * @author: wyj
 * @date: 2021/04/20
 */
public class SetListNodeUtil {
    //生成测试用节点工具
    public static ListNode setListNode(int[] l1) {
        ListNode listNode=new ListNode();
        listNode.next= doSet(0,l1);
        return listNode.next;
    }

    private static ListNode doSet(int i, int[] l1) {
        if (i == l1.length) {
            return null;
        }
        ListNode listNode = new ListNode(l1[i]);
        listNode.next=doSet(i+1,l1);
        return listNode;
    }
}
