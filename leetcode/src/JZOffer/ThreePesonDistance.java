package JZOffer;

import java.util.*;

public class ThreePesonDistance {
    public int threePesonDistance(int m, int n, List<Integer> list){
        int len=list.size();
        long result =0;
        for(int index=0;index<len-2;index++){
            int cursor = index+1;
            while (cursor<len && list.get(index)+n>=list.get(cursor)){
                cursor++;
            }
            if(cursor-index<3){
                index = cursor-1;
                continue;
            }
            while (cursor-index>=3 ){
                result +=(cursor-index-1)*(cursor-index-2)/2;
                index++;
            }


            //System.out.println(result);

        }
        return (int)(result%99997867);
    }
    public static void main(String[] args) {
//        for(int i=1;i<=100;i++){
//            System.out.print(" "+i+" ");
//        }
//        System.out.println();
        int m = 0;
        int n = 0;
        long result = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        List<Integer> list = new ArrayList<>(m);
        for (int i = 0,j=0; i < m; i++) {
            int temp = scanner.nextInt();
            list.add(temp);

            if(i>=2){
                while (i-j>=2 && list.get(i)-list.get(j)<=n){
                    result+=(i-j)*(i-j-1)/2;
                    j++;
                }
            }


        }
        System.out.println(result);

    }
}
