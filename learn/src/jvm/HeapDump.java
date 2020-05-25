package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出测试
 * Edit Configurations中为HeapDump设置VM options
 *      -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./jvmout
 *  -Xms20m 堆最小内存
 *  -Xmx20m 堆最大内存
 *  -XX:+HeapDumpOnOutOfMemoryError 指定生成堆内存溢出快照
 *  -XX:HeapDumpPath=./jvmout 指定输出的堆内存溢出快照路径为src同级的jvmout下
 * @author: wyj
 * @date: 2020/05/26
 */
public class HeapDump {
    public static void main(String[] args) {
        List<HeapDump> list=new ArrayList<>();
        while (true){
            list.add(new HeapDump());
        }
    }
}
