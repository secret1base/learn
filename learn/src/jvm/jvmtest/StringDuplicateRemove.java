package jvm.jvmtest;

import datastructure.Queue;

import java.util.LinkedList;

/**
 * -XX:+UseStringDeduplication 开启字符串去重
 * -XX:+UseG1GC使用G1
 * -XX:StringDeduplicationAgeThreshold=1 存活一次就去重
 * -Xmx256m 限制堆内存大小
 * 字符串去重验证 1
 * @author: wyj
 * @date: 2020/06/16
 */
public class StringDuplicateRemove {
    private static final LinkedList<String> LOTS_OF_STRINGS = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        //第一次测试:-Xmx256m -XX:+UseG1GC 输出30
        //第二次测试:-Xmx256m -XX:+UseG1GC -XX:+UseStringDeduplication -XX:StringDeduplicationAgeThreshold=1 输出50
        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    LOTS_OF_STRINGS.add(new String("String " + j));
                }
                System.out.println("zz");
            }
            iteration++;
            System.out.println("Survived Iteration: " + iteration);
            Thread.sleep(100L);
        }

    }
}
