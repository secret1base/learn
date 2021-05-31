package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R31_2 {
    /**
     * 			执行耗时:1 ms,击败了97.62% 的Java用户
     * 			内存消耗:38.6 MB,击败了62.52% 的Java用户
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        boolean flag=false;
        for (int i = nums.length-1; i >=0; i--) {
            if(i>0&&nums[i]>nums[i-1]){
                //破坏降序
                //从后往前找比i-1大的数
                for (int j = nums.length - 1; j >i-1; j--) {
                    if(nums[j]>nums[i-1]){
                        //交换位置
                        int tmp=nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1]=tmp;
                        //对i-1后面进行升序排列
                        for (int k = i-1+1; k <nums.length-1; k++) {
                            for (int a=k+1;a<nums.length; a++){
                                if(nums[k]>nums[a]){
                                    int t=nums[k];
                                    nums[k] = nums[a];
                                    nums[a]=t;
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
        if(!flag){
            for (int k = 0; k <nums.length-1; k++) {
                for (int a=k+1;a<nums.length; a++){
                    if(nums[k]>nums[a]){
                        int t=nums[k];
                        nums[k] = nums[a];
                        nums[a]=t;
                    }
                }
            }
        }
    }
}
