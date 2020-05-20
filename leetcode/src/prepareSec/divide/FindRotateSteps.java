package prepareSec.divide;

import prepareSec.dp.KConcatenationMaxSum;

import java.util.*;

public class FindRotateSteps {

    private Map<Character, List<Integer>> map;
    private int strLen = 0;
    public int findRotateSteps(String ring, String key) {
        int len = ring.length();
        map = new HashMap<Character, List<Integer>>(4);
        strLen = len;
        for(int i=0;i<len;i++){
            Character ch = ring.charAt(i);
            if(!map.keySet().contains(ch)){
                List<Integer> indexList = new ArrayList<Integer>(1);
                indexList.add(i);
                map.put(ch, indexList);
            }else {
                List<Integer> list = map.get(ch);
                list.add(i);
                map.put(ch, list);
            }
        }

        int[] dp = new int[ring.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        boolean flag = true;
        for(int i=0;i<key.length();i++){
            Character currentCh = key.charAt(i);
            List<Integer> indexList = map.get(currentCh);
            int[] dp1 = new int[ring.length()];
            Arrays.fill(dp1, Integer.MAX_VALUE);
            for(Integer index:indexList){
                if(flag == true){
                    dp1[index] = Math.min(index, len-index)+1;
                }else {

                    for(int j=0;j<dp.length;j++){
                        if(dp[j] != Integer.MAX_VALUE ){
                            dp1[index] = Math.min(dp[j]+Math.min(Math.abs(index-j), Math.min(len-index+j, len+index-j))+1, dp1[index]);
                        }
                    }
                }
            }
            flag = false;
            dp = dp1;
        }

        Arrays.sort(dp);
        int result = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(dp[i]!=Integer.MAX_VALUE){
                result = Math.min(result, dp[i]);
            }
        }
        return result;
    }

//    public int find(String ring, String key, int index1, int index2){
//        if(index2 == key.length()){
//            return 0;
//        }
//
//        System.out.println("index1: " + index1 + " is " + ring.charAt(index1) + " index2: " + index2 + " is: " + key.charAt(index2));
//        Character currentCh = key.charAt(index2);
//        List<Integer> indexList = map.get(currentCh);
//
//        int rotateStep = 0;
//        int totalStep = Integer.MAX_VALUE;
//        for(int index: indexList){
//            rotateStep = Math.abs(index-index1);
//            if(index>index1){
//                rotateStep = Math.min(rotateStep, index1+strLen-index);
//            }else {
//                rotateStep = Math.min(rotateStep, index+strLen-index1);
//            }
//
//            totalStep = Math.min(totalStep, rotateStep+1 + find(ring, key, index, index2+1));
//
//        }
//        return totalStep;
//    }

    public static void main(String[] args){
        FindRotateSteps findRotateSteps = new FindRotateSteps();
        System.out.println(findRotateSteps.findRotateSteps("godding", "gd"));

    }
}
