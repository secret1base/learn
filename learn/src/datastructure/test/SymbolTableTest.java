package datastructure.test;

import datastructure.SymbolTable;

/**
 * 测试无序符号表：插入键值对、根据key删除键值对、根据key获取值、获取长度、判空、查询、遍历
 * @author: wyj
 * @date: 2020/05/22
 */
public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer,String> table= new SymbolTable<>();
        table.put(1,"yiyi");
        table.put(2,"erer");
        table.put(3,"sansan");
        table.put(4,"sisi");
        table.put(5,"wuwu");
        table.put(6,"liuliu");
        table.put(7,"qiqi");
        table.put(8,"baba");
        table.put(9,"jiujiu");
        System.out.println(table.size());
        System.out.println(table.isEmpty());
        System.out.println("-------------------------");
        for (String s : table) {
            System.out.println(s);
        }
        table.put(1,"yiyi变了");
        table.put(9,"jiujiu变了");
        System.out.println("--------------------");
        for (String s : table) {
            System.out.println(s);
        }
        System.out.println(table.remove(9));
        System.out.println(table.size());
        table.foreach();
    }
}
