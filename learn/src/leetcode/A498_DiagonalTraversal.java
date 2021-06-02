//package leetcode;
//
///**
// * 498. 对角线遍历
// * @author: wyj
// * @date: 2021/06/02
// */
//public class A498_DiagonalTraversal {
//    /**
//     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，
//     * 对角线遍历如下图所示。
//     *  示例:
//     *  输入:
//     * [
//     *  [ 1, 2, 3 ],
//     *  [ 4, 5, 6 ],
//     *  [ 7, 8, 9 ]
//     * ]
//     * 输出:  [1,2,4,7,5,3,6,8,9]
//     * @param mat
//     * @return
//     */
//    /**
//     * 解题思路：498.png
//     * @param mat
//     * @return
//     */
//    public int[] findDiagonalOrder(int[][] mat) {
//        if(mat.length==0){
//            return null;
//        }
//        int total=mat.length*mat[0].length;
//        int[] r=new int[total];
//        //对角线
//        //默认规律为右->左下->右->左上，但是一旦没有到达底部或者顶部就到达边界，则方向改为向下
//        //右：1,0
//        //左下：-1,1
//        //右：1,0
//        //左上：1,-1
//        //提前到达边界:0,-1
//        int x=1;
//        int y=0;
//        boolean upFlag=false;
//        int row=0;
//        int col=0;
//        for (int i=0;i<total;i++){
//            r[i]=mat[row][col];
//            if(row==0){
//                //到达上面顶点
//                if(col+1<mat[row].length){
//                    //向右一格
//                    col++;
//                    i++;
//                    r[i]=mat[row][col];
//                }else{
//                    //向下一格
//                    row++;
//                    i++;
//                    r[i]=mat[row][col];
//                }
//            }else if(row==mat.length-1){
//                //到达底部
//                if(col-1>=0)
//            }
//        }
//    }
//}
