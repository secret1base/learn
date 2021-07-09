package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. 课程表
 * @author: wyj
 * @date: 2021/06/30
 */
public class A207_Curriculum {
    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     *  在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
     * 示如果要学习课程 ai 则 必须 先学习课程 bi 。
     *  例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     *  请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     *  示例 1：
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     *  示例 2：
     * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     * 输出：false
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     * 1 <= numCourses <= 105
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     *
     * 			执行耗时:131 ms,击败了5.02% 的Java用户
     * 			内存消耗:38.9 MB,击败了75.74% 的Java用户
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //注意：前置课程可能有多个
//        3,{{1,0},{1,2},{0,1}}为false
        //存储前置课程
        Map<Integer, List<Integer>> courses=new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = courses.get(prerequisite[0]);
            if(list==null){
                list=new ArrayList<>();
            }
            list.add(prerequisite[1]);
            courses.put(prerequisite[0],list);
        }
        //存储完成课程
        Map<Integer,Integer> finishMap=new HashMap<>();
        while (true){
            //更新前的长度
            int curr = finishMap.keySet().size();
            for(int i=0;i<numCourses;i++){
                //获取前置课程
                List<Integer> list = courses.get(i);
                if(list==null){
                    //如果没有前置课程，则直接完成
                    finishMap.put(i,0);
                }else{
                    //查看前置课程是否完成,前置课程需全部完成
                    boolean flag=true;
                    for (Integer a : list) {
                        Integer integer = finishMap.get(a);
                        if(integer==null){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        finishMap.put(i,0);
                    }
                }
            }
            //更新后的长度
            int after = finishMap.keySet().size();
            //如果长度不再改变，则结束循环
            if(curr==after){
                break;
            }
        }
        return numCourses==finishMap.keySet().size();
    }

    public static void main(String[] args) {
        System.out.println(new A207_Curriculum().canFinish(2,new int[][]{{1,0}}));
        System.out.println(new A207_Curriculum().canFinish(2,new int[][]{{1,0},{0,1}}));
        System.out.println(new A207_Curriculum().canFinish(3,new int[][]{{1,0},{1,2},{0,1}}));
    }
}
