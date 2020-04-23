package prepare;

import java.util.HashSet;
import java.util.Set;

public class IsHappayAchieve {

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>(4);

        while (!set.contains(n)){
            //存储原来的数
            set.add(n);
            int count = 0;
            while (n!=0){
                int last=n%10;
                count += last*last;
                n /= 10;
            }
            if(count==1){
                return true;
            }
            n = count;
        }
        return false;
    }
}
