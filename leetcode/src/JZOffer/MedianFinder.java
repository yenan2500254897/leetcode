package JZOffer;

import java.util.*;

public class MedianFinder {


    private Queue<Integer> maxVal;
    private Queue<Integer> minVal;
    /** initialize your data structure here. */
    public MedianFinder() {

        maxVal = new PriorityQueue<>((x,y)->y-x);
        minVal = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(!minVal.isEmpty() && num>minVal.peek()){
            maxVal.add(minVal.poll());
        }
        maxVal.add(num);

    }

    public double findMedian() {
        if(maxVal.size()==0){
            return 0;
        }
        while (maxVal.size()>minVal.size()){
            minVal.add(maxVal.poll());
        }
        if(maxVal.size()==minVal.size()){
            return (maxVal.peek() + minVal.peek())/2.0;
        }
        return minVal.peek();
    }

    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(6);
//        medianFinder.addNum(7);

    }
}
