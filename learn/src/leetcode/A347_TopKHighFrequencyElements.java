package leetcode;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * @author: wyj
 * @date: 2021/07/02
 */
public class A347_TopKHighFrequencyElements {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *  示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *  示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     * 			执行耗时:36 ms,击败了5.03% 的Java用户
     * 			内存消耗:43.2 MB,击败了5.16% 的Java用户
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num,count+1);
        }
        //123 通过两个队列进行实现
        Deque<TKF> path=new LinkedList<>();
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            Deque<TKF> tmp=new LinkedList<>();
            //当队列的第一个元素比当前元素小，则取出第一个元素放入tmp中
            while (path.size()!=0&&path.peekFirst().count<value){
                TKF tkf = path.pollFirst();
                tmp.offerLast(tkf);
            }
            TKF tkf = new TKF(key,value);
            path.offerFirst(tkf);
            //将之前取出的放回去
            while (tmp.size()!=0){
                path.offerFirst(tmp.pollLast());
            }
            //如果长度不符合要求则去掉一个
            if(path.size()==k+1){
                path.pollFirst();
            }
        }
        int[] r=new int[k];
        for (int i = 0; i < k; i++) {
            TKF tkf = path.pollFirst();
            r[i]=tkf.key;
        }
        return r;
    }
    class TKF{
        int key;
        int count;

        public TKF(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[] ints = new A347_TopKHighFrequencyElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
