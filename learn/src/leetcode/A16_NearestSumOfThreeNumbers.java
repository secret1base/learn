package leetcode;

import java.util.Arrays;

/**
 * 16.最接近的三数之和
 * @author: wyj
 * @date: 2021/04/19
 */
public class A16_NearestSumOfThreeNumbers {
    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 示例：
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 提示：
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     */
    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);
    }

    /**
     * 1、先进行排序
     * 2、与三数之和相同取起始值a后，再取两个指针分别从左右进行移动
     * 3、需要注意1、下标对应值重复的需要直接跳过{1,1,2,3}如这种情况不应执行两次1 2、注意不要让a、left、right这三个索引值相等
     * 4、在判断最接近值时，与三数之和不同，三数之和只要判断结果等于0并进行记录就好了，判断最接近值需要判断左边的值和右边的值哪个更接近(right和right+1)，需要判断两次
     * 5、对本次的两个值分别与目标值相减取绝对值，绝对值(abs)越小越接近
     * 5、得出本次最接近的绝对值(abs)后与历史绝对值(min)比较，如果本次绝对值(abs)比历史绝对值(min)小，则替换绝对值(min=abs)，然后记录结果(result=pre or now[取绝对值最小的值])
     * 执行用时：28 ms, 在所有 Java 提交中击败了11.24%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了68.76%的用户
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int a;
        int left;
        int right;
        int min=Integer.MAX_VALUE;
        int result=0;
        for (a=0;a<length;a++){
            if(a>0&&nums[a]==nums[a-1]){
                continue;
            }
            for(left=a+1;left < length; left++){
                if (left>a+1&&nums[left] == nums[left-1]) {
                    continue;
                }
                right=length-1;
                //注意判断right必须比left+1大，因为right处理完后需要的值是取两边的，分别需要对right和right+1进行比较
                while (left < right-1&&nums[left]+nums[right]+nums[a]>target) {
                    right--;
                }
                if(left==right){
                    break;
                }
                //比较两次结果值
                int now = nums[left] + nums[right] + nums[a];
                int pre;
                if(right+1<length){
                    pre = nums[left] + nums[right+1] + nums[a];
                }else{
                    pre=now;
                }
                int abs = Math.abs(target - now);
                int abs2 = Math.abs(target - pre);
                if(abs<abs2){
                    if(abs<min){
                        min=abs;
                        result=now;
                    }
                }else{
                    if(abs2<min){
                        min=abs2;
                        result=pre;
                    }
                }
            }
        }
        return result;
    }

}
