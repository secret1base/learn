package leetcode;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * @author: wyj
 * @date: 2021/07/23
 */
public class A1493_TheLongestSubarrayWith1AfterDeletingAnElement {
    /**
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     *  请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     *  如果不存在这样的子数组，请返回 0 。
     *  提示 1：
     *  输入：nums = [1,1,0,1]
     * 输出：3
     * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
     *  示例 2：
     *  输入：nums = [0,1,1,1,0,1,1,0,1]
     * 输出：5
     * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
     *  示例 3：
     *  输入：nums = [1,1,1]
     * 输出：2
     * 解释：你必须要删除一个元素。
     *  示例 4：
     *  输入：nums = [1,1,0,0,1,1,1,0,1]
     * 输出：4
     *  示例 5：
     *  输入：nums = [0,0,0]
     * 输出：0
     *  提示：
     *  1 <= nums.length <= 10^5
     *  nums[i] 要么是 0 要么是 1 。
     *
     *  	执行耗时:3 ms,击败了53.81% 的Java用户
     * 		内存消耗:46.7 MB,击败了95.80% 的Java用户
     */
    public int longestSubarray(int[] nums) {
        //注意1,1,1的长度是2，因为必须删除掉一个元素
        //建立一个如下形式的数组：2,-2,1,0,0=1,1,0,0,1,对应数组中的0无意义
        int[] store=new int[nums.length];
        int index=0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(i==0){
                if(num==1){
                    store[index]=1;
                }else{
                    store[index]=-1;
                }
                continue;
            }
            int s = store[index];
            if(num==1){
                if(s>0){
                    store[index]=s+1;
                }else{
                    index++;
                    store[index]=1;
                }
            }else{
                if(s>0){
                    index++;
                    store[index]=-1;
                }else{
                    store[index]=s-1;
                }
            }
        }
        //2,-2,1,0,0
        //根据数组求出最长值
        int max=0;
        //必须删除一个元素
        for (int i = 0; i <= index;i++){
            int a = store[i];
            if(a>0){
                if(i+2<=index&&store[i+1]==-1){
                    a = a + store[i + 2];
                }
                max=Math.max(max,a);
            }
        }
        if(index==0&&max>0){
            //必须删除一个元素，且index为0时，代表[3]==[1,1,1]，则影响长度
            max--;
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new A1493_TheLongestSubarrayWith1AfterDeletingAnElement().longestSubarray(new int[]{1, 1,  0, 1});
        System.out.println(i);
    }
}
