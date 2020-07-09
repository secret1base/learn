package datastructure;

/**
 * 并查集
 * @author: wyj
 * @date: 2020/07/09
 */
public class UnionFindTree {
    /**分组及元素*/
    private int[] eleAndGroup;
    /**当前分组数*/
    private int count;
    /**每个元素的节点数(不包含上级节点)*/
    private int sz[];
    public UnionFindTree(int size){
        eleAndGroup=new int[size];
        count=size;
        sz=new int[size];
        for (int i=0;i<size;i++){
            eleAndGroup[i]=i;
        }
        for (int i=0;i<size;i++){
            sz[i]=1;
        }
    }

    /**
     * 当前分组数
     * @return
     */
    public int getCount(){
        return count;
    }

    /**
     * 对两个节点进行连接测试
     * @param a
     * @param b
     * @return
     */
    public boolean connectTest(int a,int b){
        return find(a)==find(b);
    }

    /**
     * 获取根节点
     * @param a
     * @return
     */
    private int find(int a) {
        while (true){
            if(a==eleAndGroup[a]){
                return a;
            }
            a=eleAndGroup[a];
        }
    }

    /**
     * 合并(连通)两个分组为一个分组
     * @param a
     * @param b
     */
    public void union(int a,int b){
        //判断是否存在连接关系
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot!=bRoot){
            //路径压缩处理
            if(sz[aRoot]>sz[bRoot]){
                eleAndGroup[bRoot]=aRoot;
                sz[aRoot]+=sz[bRoot];
            }else{
                eleAndGroup[aRoot]=bRoot;
                sz[bRoot]+=sz[aRoot];
            }
            count--;
        }
    }
}
