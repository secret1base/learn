package jvm.classStruct;

/**
 * @author: wyj
 * @date: 2020/06/28
 */
public class TryCatchStruct {
    public static void main(String[] args) {
        int i=1;
        try{
            i=10;
        }catch (RuntimeException r){
            i=2;
        }catch (Exception e){
            i=3;
        }
    }
}
/**
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=1, locals=3, args_size=1
 *          0: iconst_1
 *          1: istore_1
 *          2: bipush        10
 *          4: istore_1
 *          5: goto          17
 *          8: astore_2
 *          9: iconst_2
 *         10: istore_1
 *         11: goto          17
 *         14: astore_2
 *         15: iconst_3
 *         16: istore_1
 *         17: return
 *       Exception table:
 *          from    to  target type
 *              2     5     8   Class java/lang/RuntimeException
 *              2     5    14   Class java/lang/Exception
 */
