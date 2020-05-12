package prepareSec.dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SubarrayBitwiseORs {

    public int subarrayBitwiseORs(int[] A) {
        int len = A.length;
        if(len == 1){
            return 1;
        }

        Set<Integer> set=new HashSet<>(4);


        for(int i=0;i<len;i++){
            set.add(A[i]);
            for(int j=i-1;j>=0;j--) {
                if((A[j] | A[i]) == A[j]){
                    break;
                }
                A[j] |= A[i];
                set.add(A[j]);
            }
        }
        return set.size();
    }
}
