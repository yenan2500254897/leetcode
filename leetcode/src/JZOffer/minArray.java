package JZOffer;

public class minArray {
    public int minArray(int[] numbers) {
        int minVal = numbers[0];
        int len = numbers.length;
        for(int i=0;i<len-1;i++){
            if(numbers[i]>numbers[i+1]){
                minVal = Math.min(minVal, numbers[i+1]);
            }
        }
        return minVal;
    }
}
