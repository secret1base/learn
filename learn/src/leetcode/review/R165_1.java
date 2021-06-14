package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R165_1 {
//输入：version1 = "1.01", version2 = "1.001"
//输出：0
//解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
// 示例 2：
//输入：version1 = "1.0", version2 = "1.0.0"
//输出：0
//解释：version1 没有指定下标为 2 的修订号，即视为 "0"
// 示例 3：
//输入：version1 = "0.1", version2 = "1.1"
//输出：-1
//解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < ve
//rsion2
//输入：version1 = "1.0.1", version2 = "1"
//输出：1
//输入：version1 = "7.5.2.4", version2 = "7.5.3"
//输出：-1
public static void main(String[] args) {
    int i = new R165_1().compareVersion("7.5.2.4", "7.5.3");
    System.out.println(i);
}
//			执行耗时:2 ms,击败了16.70% 的Java用户
//			内存消耗:36.6 MB,击败了44.54% 的Java用户
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int x=0;
        int y=0;
        while (x < a.length||y < b.length){
            int q=x<a.length?Integer.parseInt(a[x]):0;
            int p=y<b.length?Integer.parseInt(b[y]):0;
            if(q==p){
                x++;
                y++;
            }else if(q>p){
                return 1;
            }else{
                return -1;
            }
        }
        return 0;
    }
}
