package leetcode;


/**
 * 547. 省份数量（原朋友圈）
 * @author: wyj
 * @date: 2021/06/30
 */
public class A547_NumberOfProvincesOriginalCircleOfFriends {
    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
     *  省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *  给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而
     * isConnected[i][j] = 0 表示二者不直接相连。
     *  返回矩阵中 省份 的数量。
     *  示例 1：
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     *  示例 2：
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     * 通过并查集实现
     * 			执行耗时:2 ms,击败了46.79% 的Java用户
     * 			内存消耗:38.9 MB,击败了96.77% 的Java用户
     */
    public int findCircleNum(int[][] isConnected) {
        //根据题意总共的城市数量为isConnected.length
        UFT uft = new UFT(isConnected.length);
        for (int row = 0; row < isConnected.length; row++) {
            for (int col = 0; col < isConnected[row].length; col++) {
                if(row!=col&&isConnected[row][col]==1){
                    uft.union(row,col);
                }
            }
        }
        return  uft.getCount();
    }

    public static void main(String[] args) {
        int circleNum = new A547_NumberOfProvincesOriginalCircleOfFriends().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});

    }
    class UFT {
        /**分组及元素*/
        private int[] eleAndGroup;
        /**当前分组数*/
        private int count;
        /**每个元素的节点数(不包含上级节点)*/
        private int sz[];
        public UFT(int size){
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
        public int[] getSz(){
            return sz;
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
}

