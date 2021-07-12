package leetcode;

import java.util.*;

/**
 * 210. 课程表 II
 * @author: wyj
 * @date: 2021/07/12
 */
public class A210_CurriculumII {
    /**
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     *  在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     *  给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     *  可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     *  示例 1:
     *  输入: 2, [[1,0]]
     * 输出: [0,1]
     * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     *  示例 2:
     *  输入: 4, [[1,0],[2,0],[3,1],[3,2]]
     * 输出: [0,1,2,3] or [0,2,1,3]
     * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     *  说明:
     *  输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
     *  你可以假定输入的先决条件中没有重复的边。
     *  提示:
     *  这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
     *  通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
     *  拓扑排序也可以通过 BFS 完成。
     *  Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
     *
     *
     *  实现代码比较多，但是思路连续，所以是比较简单的，不过效率有点低
     *  		执行耗时:48 ms,击败了5.01% 的Java用户
     * 			内存消耗:39.5 MB,击败了67.03% 的Java用户
     *
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //加载所有课的前置条件
        Map<Integer, List<Integer>> preMap=new HashMap<>();
        for (int[] p : prerequisites) {
            List<Integer> list = preMap.get(p[0]);
            if(list==null){
                list=new ArrayList<>();
            }
            list.add(p[1]);
            preMap.put(p[0],list);
        }
        //记录已经学习的课程
        boolean[] ok=new boolean[numCourses];
        List<Integer> oks=new ArrayList<>();
        while (true){
            int before = oks.size();
            for (int i = 0; i < numCourses; i++) {
                List<Integer> list = preMap.get(i);
                //没学过的课程
                if(!ok[i]){
                    //没有前置课程，可以直接学
                    if(list==null){
                        oks.add(i);
                        ok[i]=true;
                    }else{
                        //必须前置课程都学了
                        boolean flag=true;
                        for (Integer integer : list) {
                            if(!ok[integer]){
                                //有没学的前置课程
                                flag=false;
                                break;
                            }
                        }
                        if(flag){
                            oks.add(i);
                            ok[i]=true;
                        }
                    }
                }
            }
            if(before==oks.size()){
                //长度不再变化，说明到底了
                break;
            }
        }
        if(oks.size()==numCourses){
            int[] store=new int[numCourses];
            for (int i = 0; i < numCourses; i++){
                store[i] = oks.get(i);
            }
            return store;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] order = new A210_CurriculumII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(Arrays.toString(order));
    }
}
