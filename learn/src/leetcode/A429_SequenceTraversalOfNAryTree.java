package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N叉树的层序遍历
 * @author: wyj
 * @date: 2021/07/12
 */
public class A429_SequenceTraversalOfNAryTree {
    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     *  树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     *  示例 1：
     *  429(1).png
     * 输入：root = [1,null,3,2,4,null,5,6]
     * 输出：[[1],[3,2,4],[5,6]]
     *  示例 2：
     *  429(2).png
     * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
     * null,13,null,null,14]
     * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
     *  提示：
     *  树的高度不会超过 1000
     *  树的节点总数在 [0, 10^4] 之间
     *
     *  一道普通的层序遍历题，和二叉树层序遍历唯一的区别是节点数不确定
     *  		执行耗时:3 ms,击败了86.81% 的Java用户
     * 			内存消耗:39.4 MB,击败了43.47% 的Java用户
     */
    public List<List<Integer>> levelOrder(NNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<NNode> path=new LinkedList<>();
        path.offer(root);
        while (!path.isEmpty()){
            List<Integer> tmp=new ArrayList<>();
            int size = path.size();
            for (int i = 0; i < size; i++) {
                NNode node = path.pollFirst();
                if(node==null){
                    continue;
                }
                tmp.add(node.val);
                List<NNode> children = node.children;
                if(children!=null){
                    for (NNode child : children) {
                        path.offerLast(child);
                    }
                }
            }
            if(tmp.size() > 0){
                list.add(tmp);
            }
        }
        return list;
    }
}
class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
