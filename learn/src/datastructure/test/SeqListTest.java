package datastructure.test;

import datastructure.SeqList;

/**
 * @author: wyj
 * @create: 2020-05-20 13:28
 */
public class SeqListTest {
    public static void main(String[] args) {
        SeqList<String> seqList = new SeqList(5);
        for(int i=0;i<10;i++){
            seqList.insert(i+"");
        }
//        for (String s : seqList) {
//            System.out.println(s);
//        }
        seqList.insert(3,"zzz");//预计为 0 1 zzz 2 3
//        for (String s : seqList) {
//            System.out.println(s);
//        }
        seqList.remove(3);
        for (String s : seqList) {
            System.out.println(s);
        }
    }
}
