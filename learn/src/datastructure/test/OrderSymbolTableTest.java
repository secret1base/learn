package datastructure.test;

import datastructure.OrderSymbolTable;

/**
 * 有序符号表
 * @author: wyj
 * @date: 2020/05/27
 */
public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> map = new OrderSymbolTable<>();
        map.put(9,"9A");
        map.put(2,"2A");
        map.put(3,"3A");
        map.put(7,"7A");
        map.put(5,"5A");
        map.put(99,"99A");
        map.put(1,"1A");
        map.put(6,"6A");
        map.put(97,"97A");
        map.put(90,"90A");
        map.put(29,"29A");
        map.put(99,"39A");
        map.foreach();
        System.out.println(map.size()==11);
        System.out.println(map.remove(99));
        System.out.println(map.size()==10);
        System.out.println(map.get(9));
    }
}
