package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 179. 最大数
 * @author: wyj
 * @date: 2021/06/01
 */
public class A179_MostOfLargeNumbers {
    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     *  注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     *  示例 1：
     * 输入：nums = [10,2]
     * 输出："210"
     *  示例 2：
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     *  示例 3：
     * 输入：nums = [1]
     * 输出："1"
     *  示例 4：
     * 输入：nums = [10]
     * 输出："10"
     *  提示：
     *  1 <= nums.length <= 100
     *  0 <= nums[i] <= 109
     */
    /**
     * 解题思路:这题需要注意的是乍一看直接根据字符串排序即可实际上不是的
     * 31需要比3小34需要比3大，另外还有一些其它情况如311比31小，3131比313小，
     * 比较讨巧的解题方案是比较a+b和b+a的值如果a+b>b+a则取a在前
     * 执行耗时:6 ms,击败了77.06% 的Java用户
     * 内存消耗:37.5 MB,击败了83.57% 的Java用户
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> list=new ArrayList<>();
        for (int num : nums) {
            list.add(Integer.toString(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb=new StringBuilder();
        for (int i = list.size() - 1; i >=0; i--) {
            sb.append(list.get(i));
        }
        //处理00
        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new A179_MostOfLargeNumbers().largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }
}
