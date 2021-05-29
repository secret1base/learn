package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R470_2 {
    public int rand10() {
        int nums=11;
        while (nums>10){
            nums=(rand7()-1)*7+rand7();
        }
        return nums;
    }
    public int rand7() {
        return 0;
    }
}
