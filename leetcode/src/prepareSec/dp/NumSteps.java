package prepareSec.dp;

public class NumSteps {
    public int numSteps(String s) {
        int len = s.length();
        if(len == 1){
            return 1;
        }

        int carrier = 0;
        int index = len-1;
        int step = 0;
        while (index>=0){
            if(s.charAt(index) == '0'){
                if(carrier == 0){
                    step++;
                }else {
                    step+=2;
                    carrier = 1;
                }
            }else {
                if(index == 0){
                    if(carrier == 1){
                        step++;
                    }
                    break;
                }
                if(carrier == 0){
                    step+=2;
                    carrier = 1;
                }else {
                    step++;
                    carrier = 1;
                }
            }
            index--;
        }
        return step;
    }
}
