package minimization;

import com.sun.org.apache.xpath.internal.operations.Bool;
import prepareSec.divide.BeautifulArray;

public class CanIWin {

    public int N = 0;
    public Boolean[][] record;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        N = maxChoosableInteger;
        if(maxChoosableInteger >= desiredTotal){
            return true;
        }

        if(maxChoosableInteger * (1+maxChoosableInteger)/2<desiredTotal){
            return false;
        }
        record = new Boolean[1<<N][2];
        return dfs(0, desiredTotal, 0);
    }

    public boolean dfs(int state, int desiredTotal, int level){
        if(desiredTotal<=0){
            record[state][level%2] =level%2 == 0?false:true;
            return level%2 == 0?false:true;
        }


        boolean result = level%2 == 0?false:true;
        for(int i=0;i<N;i++){
            if((state & 1<<i) == 0){

                boolean temp = record[state|1<<i][(level+1)%2] == null?dfs(state | 1<<i, desiredTotal-i-1, (level+1)%2):record[state|1<<i][(level+1)%2];
                if(level%2 == 0){
                    if(temp == true){
                        result = true;
                        break;
                    }
                }else {
                    if(temp == false){
                        result = false;
                        break;
                    }
                }


            }
        }
        record[state][level%2] = result;
        return result;
    }

    public static void main(String[] args){
        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(18, 79));
    }
}
