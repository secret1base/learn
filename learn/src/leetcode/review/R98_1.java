package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/10
 */
public class R98_1 {
    // 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
    //			执行耗时:2 ms,击败了27.40% 的Java用户
    //			内存消耗:38.3 MB,击败了8.13% 的Java用户
    public boolean isValidBST(TreeNode root) {
        //通过中序遍历后校验是否升序
        List<Integer> list=new ArrayList<>();
        record(root,list);
        for (int i = 0; i < list.size(); i++) {
            if(i+1<list.size()&&list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private void record(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        record(root.left,list);
        list.add(root.val);
        record(root.right,list);
    }


}
