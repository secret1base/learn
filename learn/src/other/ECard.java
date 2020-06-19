package other;

import java.util.Random;

/**
 * 赌博默示录：E卡(emperor card)胜率计算
 * 规则如下:
 *  皇帝卡组:[市民,市民，市民，市民，皇帝] 1,1,1,1,2
 *  奴隶卡组:[市民,市民，市民，市民，奴隶] 1,1,1,1,0
 *  皇帝逃脱则皇帝赢
 *  奴隶击杀皇帝则奴隶赢
 * 结论:结果没啥值得期待的，客观角度，皇帝胜率就是80%
 * @author: wyj
 * @date: 2020/06/19
 */
public class ECard {
    private static int emperorWinCount=0;
    private static int slaveWinCount=0;
    private int[] emperors=null;
    private int[] slaves=null;

    public ECard(){
        emperors=new int[]{1,1,1,1,2};
        slaves=new int[]{1,1,1,1,0};
    }

    public static void main(String[] args) {
        for (int i=0;i<10000;i++){
            if(new ECard().fight()){
                emperorWinCount++;
            }else{
                slaveWinCount++;
            }
        }
        int i = emperorWinCount * 100 / (emperorWinCount + slaveWinCount);
        System.out.println(i);
    }

    private boolean fight(){
        while (true){
            int e = getRandom(this.emperors);
            int s = getRandom(this.slaves);
            if(e==2&&s==0){
                //皇帝卡对奴隶卡，奴隶胜
                return false;
            }else if(e==2){
                //皇帝卡已出，对家非奴隶卡，皇帝胜
                return true;
            }else if(s==0){
                //奴隶卡已出，对家非皇帝卡，皇帝胜
                return true;
            }
        }

    }

    private int getRandom(int[] arr){
        //检查是否正常
        boolean validate=false;
        for (int i : arr) {
            if(i>=0){
                validate=true;
            }
        }
        if (!validate){
            throw new RuntimeException("不应存在卡组使用完后仍然取值的情况!");
        }
        Random random = new Random();
        while (true){
            int i = random.nextInt(5);
            int v = arr[i];
            if(v>=0){
                arr[i]=-1;
                return v;
            }
        }
    }

}

