package jvm.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串常量池位置验证
 * jdk8 -Xmx10m 限制最大堆内存 -XX:-UseGCOverheadLimit 关闭检查
 * UseGCOverheadLimit：
 *      当花费在GC上的时间超过98%并且恢复的堆不到2%，并行GC会抛出
 *      OutOfMemoryError:GC overhead limit exceeded，
 *      目的是为了检查出当堆很小时，程序长时间运行无法获得结果的情况
 */
public class StringTableOutfMemory {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i=0;i<2000000;i++){
            list.add(String.valueOf(i).intern());
        }
    }
}
