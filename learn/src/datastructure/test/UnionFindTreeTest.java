package datastructure.test;

import datastructure.UnionFindTree;

/**
 * @author: wyj
 * @date: 2020/07/09
 */
public class UnionFindTreeTest {
    public static void main(String[] args) {
        UnionFindTree uf = new UnionFindTree(20);
        {
            int p=9;
            int q=13;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=14;
            int q=16;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=11;
            int q=19;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=6;
            int q=5;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=13;
            int q=12;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=11;
            int q=14;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=6;
            int q=11;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=12;
            int q=2;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=6;
            int q=12;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=11;
            int q=19;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=17;
            int q=9;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=1;
            int q=5;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=15;
            int q=6;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=14;
            int q=12;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=14;
            int q=16;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=9;
            int q=13;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=19;
            int q=6;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=3;
            int q=2;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=19;
            int q=4;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=16;
            int q=5;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=14;
            int q=19;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=18;
            int q=5;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=5;
            int q=15;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=14;
            int q=2;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=17;
            int q=1;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=2;
            int q=19;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=1;
            int q=2;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=0;
            int q=4;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=7;
            int q=14;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=7;
            int q=2;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=3;
            int q=4;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=2;
            int q=13;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=15;
            int q=8;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=19;
            int q=13;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=0;
            int q=19;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=16;
            int q=5;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


        {
            int p=1;
            int q=7;
            if (uf.connectTest(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在同一个组中了");
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有："+uf.getCount()+"个分组");
        }


    }
}
