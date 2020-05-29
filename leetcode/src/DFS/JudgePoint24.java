package DFS;

import BFS.MaxCandies;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;

public class JudgePoint24 {

    public boolean judgePoint24(int[] nums) {

        List<Double> list = new ArrayList<Double>(4);
        for(int number:nums){
            list.add(Double.valueOf(0.0+number));
        }
        return solve(list);
    }

    public boolean solve(List<Double> list){
        int len = list.size();

        //为空
        if(len == 0){
            return false;
        }
        //长度为1
        if(len == 1){
            //System.out.println("the last value:" + list.get(0));
            return Math.abs(24-list.get(0))<1e-6?true:false;
        }
        //长度大于1
        for(int i=0;i<len;i++){
            for(int j= 0;j<len;j++){
                if(i!=j){
                    double first = list.get(i);
                    double second = list.get(j);

                    List<Double> nextList = new ArrayList<>(4);
                    for(int k=0;k<len;k++){
                        if(k!=i && k!= j){
                            nextList.add(list.get(k));
                        }
                    }

                    //加减乘除
                    for(int k=0;k<4;k++){
                        if(k==0){
                            nextList.add(first+second);
                        }else if(k==1){
                            nextList.add(first-second);
                        }else if(k == 2){
                            nextList.add(first*second);
                        }else {
                            if(second!=0.0){
                                nextList.add(first/second);
                            }else {
                                continue;
                            }
                        }

                        if(solve(nextList)){
                            return true;
                        }
                        nextList.remove(nextList.size()-1);
                    }
                }
            }
        }
        return false;
    }




    public static void main(String[] args){
        //int[] test = {4, 1, 8, 7};
//        int[] test = {1, 2, 1, 2};
        int[] test = {1,3,4,6};
        JudgePoint24 judgePoint24 =new JudgePoint24();
        System.out.println(judgePoint24.judgePoint24(test));
    }
}
