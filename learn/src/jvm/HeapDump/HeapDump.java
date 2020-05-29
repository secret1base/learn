package jvm.HeapDump;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、堆内存溢出测试
 * 前置条件
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
        String s="干扰项";
        for(int i=0;i<1000;i++){
            s+="干扰项";
        }
        while (true){
            list.add(new HeapDump());
        }
    }
    /**
     * 分析heap dump文件：
     * 方式1：使用java自带jhat工具分析：
     * cmd输入: jhat D:\xxx\learn\jvmout\java_pid41352.hprof
     * 访问: http://localhost:7000/
     * 发现References to this object:下存在大量
     *  jvm.HeapDump.HeapDump@0xff185198 (16 bytes) : ??
     *  jvm.HeapDump.HeapDump@0xff185198 (16 bytes) : ??
     *  方式2：使用Eclipse Memory Analyzer
     *      HeapDumpFile.doc
     */
}
