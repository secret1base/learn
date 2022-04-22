package leetcode;

/**
 * 278. 第一个错误的版本
 * @author: wyj
 * @date: 2021/07/27
 */
public class A278_FirstWrongVersion {
    /**
     *你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     *  假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *  你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *  示例 1：
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     *  示例 2：
     * 输入：n = 1, bad = 1
     * 输出：1
     *  提示：
     *  1 <= bad <= n <= 231 - 1
     * 			执行耗时:21 ms,击败了14.58% 的Java用户
     * 			内存消耗:34.8 MB,击败了98.33% 的Java用户
     */
    public int firstBadVersion(int n) {
        //错误的版本之后的所有版本都是错的
        int left=1;
        int right=n;
        return binarysearch(left,right);
    }

    private int binarysearch(int left, int right) {
        if(left==right){
            return left;
        }
        int mid = left + (right - left) / 2;
        if(isBadVersion(mid)){
            return binarysearch(left,mid);
        }else{
            //true
            return binarysearch(mid+1,right);
        }
    }

    //空方法，配合题目加的
    public boolean isBadVersion(int n) {
        //4以及4之后都是false
        if(n<4){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int i = new A278_FirstWrongVersion().firstBadVersion(5);
        System.out.println(i);
    }
}
