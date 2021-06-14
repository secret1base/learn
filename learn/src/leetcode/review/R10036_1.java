package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/11
 */
public class R10036_1 {
    /**
     * 			执行耗时:1 ms,击败了16.84% 的Java用户
     * 			内存消耗:37.9 MB,击败了23.39% 的Java用户
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null){
            return null;
        }
        List<TreeNode> list=new ArrayList<>();
        record(root,list);
        //左前右后
        for (int i=0;i<list.size();i++){
            TreeNode cur = list.get(i);
            if(i==0){
                //前驱
                cur.left=list.get(list.size()-1);
                //后继
            }else{
                cur.left=list.get(i-1);
            }
            if(i+1<list.size()){
                cur.right=list.get(i+1);
            }else{
                cur.right=list.get(0);
            }
        }
        return list.get(0);
    }

    private void record(TreeNode root, List<TreeNode> list) {
        if(root==null){
            return;
        }
        record(root.left, list);
        list.add(root);
        record(root.right, list);
    }
}
