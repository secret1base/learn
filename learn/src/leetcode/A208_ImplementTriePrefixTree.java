package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 208. 实现 Trie (前缀树)
 * @author: wyj
 * @date: 2021/06/24
 */
public class A208_ImplementTriePrefixTree {


//    /**
//     单纯根据题目描述进行的解答，通过了测试用例，实际上前缀树是要求通过字典树来实现的
//     * 			执行耗时:285 ms,击败了7.31% 的Java用户
//     * 			内存消耗:46.6 MB,击败了92.95% 的Java用户
//     */
//    class TreeN{
//        String p;
//        TreeN left;
//        TreeN right;
//
//        public TreeN() {
//        }
//
//        public TreeN(String p) {
//            this.p = p;
//        }
//    }
//    TreeN root=null;
//    List<String> list=new ArrayList<>();
//    public A208_ImplementTriePrefixTree() {
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if(root==null){
//            root=new TreeN(word);
//            list.add(word);
//        }else{
//            insert(root,word);
//        }
//    }
//
//    private void insert(TreeN root, String word) {
//        if(root.p.compareTo(word)<0){
//            if(root.left==null){
//                root.left=new TreeN(word);
//                list.add(word);
//            }else{
//                insert(root.left, word);
//            }
//        }else {
//            if(root.right==null){
//                root.right=new TreeN(word);
//                list.add(word);
//            }else{
//                insert(root.right,word);
//            }
//        }
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        return search(root,word);
//    }
//
//    private boolean search(TreeN root, String word) {
//        if(root==null){
//            return false;
//        }
//        int i = root.p.compareTo(word);
//        if(i==0){
//            return true;
//        }else if(i<0){
//            return search(root.left,word);
//        }else{
//            return search(root.right,word);
//        }
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        for (String s : list) {
//            if(s.indexOf(prefix)==0){
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean app = trie.search("apple");// 返回 True
        System.out.println(app);
        boolean app3 = trie.search("app");
        System.out.println(app3);
        boolean app2 = trie.startsWith("app");
        System.out.println(app2);
        trie.insert("app");
        boolean app1 = trie.search("app");// 返回 True
        System.out.println(app1);
    }
}
/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
 * 写检查。
 *  请你实现 Trie 类：
 *  Trie() 初始化前缀树对象。
 *  void insert(String word) 向前缀树中插入字符串 word 。
 *  boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false。
 *  boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
 * 则，返回 false 。
 *  示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * 单纯根据题目描述进行的解答，通过了测试用例，实际上前缀树是要求通过字典树来实现的
 * 			执行耗时:285 ms,击败了7.31% 的Java用户
 * 			内存消耗:46.6 MB,击败了92.95% 的Java用户
 * 字典树实现前缀树的思路
 * 208(1).png
 * 208(2).png
 *
 */

/**
 * isEnd的作用是标记当前节点是否为某一个字符串的节点，
 * 当出现insert app insert apple的情况时能够用来辅助知道app也是个字符串
 * 			执行耗时:51 ms,击败了30.24% 的Java用户
 * 			内存消耗:47.6 MB,击败了63.67% 的Java用户
 */
class Trie {
    Trie[] child;
    boolean isEnd;
    public Trie() {
        child=new Trie[26];
        isEnd=false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node=this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.child[index]==null){
                node.child[index]=new Trie();
            }
            node=node.child[index];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node=this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.child[index]==null){
                return false;
            }
            node=node.child[index];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node=this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(node.child[index]==null){
                return false;
            }
            node=node.child[index];
        }
        return true;
    }
}