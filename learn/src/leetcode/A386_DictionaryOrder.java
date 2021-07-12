package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 386. 字典序排数
 * @author: wyj
 * @date: 2021/07/12
 */
public class A386_DictionaryOrder {
    /**
     * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
     *  例如，
     *  给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
     *  请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
     *
     *  暴力破解
     *  		执行耗时:18 ms,击败了19.51% 的Java用户
     * 			内存消耗:43.5 MB,击败了84.35% 的Java用户
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.toString(o1).compareTo(Integer.toString(o2));
            }
        });
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new A386_DictionaryOrder().lexicalOrder(11);
        System.out.println(list);
    }
}
