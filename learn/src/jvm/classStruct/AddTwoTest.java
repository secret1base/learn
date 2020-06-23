package jvm.classStruct;

/**
 * 验证x=x++，x值不变的原理
 * @author: wyj
 * @date: 2020/06/23
 */
public class AddTwoTest {
    public static void main(String[] args) {
        /**
         * 1:istore_1 存放0到slot1中
         */
        int x=0;
        /**
         * 2:从slot1中获取值 0(操作数栈)
         * 3:slot1中的值+1变为1 (slot1)
         * 6:将当前操作数栈中的0存放到slot1中(也就是3:这一步白做了)
         */
        x=x++;
        System.out.println(x);
        /**
         *       stack=2, locals=2, args_size=1
         *          0: iconst_0
         *          1: istore_1
         *          2: iload_1
         *          3: iinc          1, 1
         *          6: istore_1
         *          7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *         10: iload_1
         *         11: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
         *         14: return
         */
    }
}
