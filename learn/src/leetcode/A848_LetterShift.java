package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 848. 字母移位
 * @author: wyj
 * @date: 2021/07/26
 */
public class A848_LetterShift {
    /**
     * 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
     *  我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
     *  例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
     *
     *  对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
     *
     *  返回将所有这些移位都应用到 S 后最终得到的字符串。
     *
     *  示例：
     *
     *  输入：S = "abc", shifts = [3,5,9]
     * 输出："rpl"
     * 解释：
     * 我们以 "abc" 开始。
     * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
     * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
     * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
     *  提示：
     *  1 <= S.length = shifts.length <= 20000
     *  0 <= shifts[i] <= 10 ^ 9
     */
    /**
     * 这题为了提升查询效率，进行了多轮优化
     * 			执行耗时:13 ms,击败了12.81% 的Java用户
     * 			内存消耗:53.1 MB,击败了5.79% 的Java用户
     * @param s
     * @param shifts
     * @return
     */
    public String shiftingLetters(String s, int[] shifts) {
        //直接对char进行操作
        char[] chars = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int x=0;
        for (int i = shifts.length-1; i >=0; i--) {
            if(x==0){
                x=shifts[i]%26;
            }else{
                x=(x+shifts[i])%26;
            }
            int a = chars[i] - '0' + x;//%26是对超出范围的优化，提升查询效率
            while (a>74){//处理超出范围部分
                a=a-26;
            }
            sb.append((char)(a + '0'));
        }
        return sb.reverse().toString();
    }
//    public String shiftingLetters(String s, int[] shifts) {
//        //不直接对char进行加减，使用map
//        Map<Character,Integer> charMap=new HashMap<>();
//        Map<Integer,Character> indexMap=new HashMap<>();
//        for (int i = 0; i < shifts.length; i++) {
//
//        }
//    }
    public static void main(String[] args) {
//        System.out.println('a'-'0');//a 49
//        System.out.println('z'-'0');//z 74
//        System.out.println((char) (74+'0'));//z 74
        System.out.println(new A848_LetterShift().shiftingLetters("abc",new int[]{3,5,9}));
//        System.out.println(new A848_LetterShift().shiftingLetters("z",new int[]{52}));
    }
}
