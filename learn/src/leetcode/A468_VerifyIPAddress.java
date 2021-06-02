package leetcode;

/**
 * 468. 验证IP地址
 * @author: wyj
 * @date: 2021/06/02
 */
public class A468_VerifyIPAddress {
    /**
     * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
     *  如果是有效的 IPv4 地址，返回 "IPv4" ；
     *  如果是有效的 IPv6 地址，返回 "IPv6" ；
     *  如果不是上述类型的 IP 地址，返回 "Neither" 。
     *  IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
     *  同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
     *  IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。
     *  比如, 2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
     *  而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
     *  所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址
     *  (即，忽略 0 开头，忽略大小写)。
     *  然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334
     *  是无效的 IPv6 地址。
     *  同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的
     *  示例 1：
     *  输入：IP = "172.16.254.1"
     * 输出："IPv4"
     * 解释：有效的 IPv4 地址，返回 "IPv4"
     *  示例 2：
     *  输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出："IPv6"
     * 解释：有效的 IPv6 地址，返回 "IPv6"
     *  示例 3：
     *  输入：IP = "256.256.256.256"
     * 输出："Neither"
     * 解释：既不是 IPv4 地址，又不是 IPv6 地址
     *  示例 4：
     *  输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
     * 输出："Neither"
     *  示例 5：
     *  输入：IP = "1e1.4.5.6"
     * 输出："Neither"
     *  提示：
     *  IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
     * @param IP
     * @return
     */
    /**
     * 这题简单，但是校验繁琐，所以给个a+
     * 			执行耗时:1 ms,击败了98.32% 的Java用户
     * 			内存消耗:36.6 MB,击败了71.79% 的Java用户
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        if(IP.contains(".")&&IP.charAt(IP.length()-1)!='.'){
            return validIPAddressIPV4(IP)?"IPv4":"Neither";
        }else if(IP.contains(":")&&IP.charAt(IP.length()-1)!=':'){
            return validIPAddressIPV6(IP)?"IPv6":"Neither";
        }
        return "Neither";
    }

    private boolean validIPAddressIPV6(String ip) {
        String[] split = ip.split(":");
        if(split.length!=8){
            return false;
        }
        ip = ip.toLowerCase();
        for (int i = 0; i < ip.length(); i++){
            //校验是否比f大
            char c = ip.charAt(i);
            if(c!=':'){
                if(c > 'f'){
                    return false;
                }
            }
        }
        for (String s : split) {
            if(s.length()>4||s.isEmpty()){
                return false;
            }
        }
        return true;
    }

    private boolean validIPAddressIPV4(String ip) {
        String[] split = ip.split("\\.");
        if(split.length!=4){
            return false;
        }
        for (String s : split) {
            if(s.length()>1&&s.charAt(0)=='0'){
                return false;
            }
            if(s.isEmpty()){
                return false;
            }
            try {
                if(Integer.parseInt(s)>255){
                    return false;
                }
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new A468_VerifyIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }
}
