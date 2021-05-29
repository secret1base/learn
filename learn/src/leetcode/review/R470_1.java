package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R470_1 {
    public int rand10() {
        int num=11;
        while (num>10){
            num=(rand7()-1)*7+rand7();
        }
        return num;
    }
    public int rand7() {
        return 0;
    }
}
