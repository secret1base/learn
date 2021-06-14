package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R470_3 {
    public int rand10() {
        int num=11;
        while (num>10){
            num=(rand7()-1)*7+rand7();
        }
        return num;
    }
    public int rand7(){
        return 0;
    }
}
