package sort;

import java.util.Arrays;

public class MergeSortAchieve {

    public int[] mergeSort(int[] array,int start, int end){
        if(start==end){
            return Arrays.copyOfRange(array, start, end+1);
        }
        int middle = (start+end)/2;
        int[] left = mergeSort(array, start, middle);
        int[] right = mergeSort(array, middle+1, end);
        return merge(left, right);

    }

    public int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex]<=right[rightIndex]){
                result[index] = left[leftIndex];
                leftIndex++;
            }else {
                result[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }
        while (leftIndex<left.length){
            result[index] = left[leftIndex];
            leftIndex++;
            index++;
        }
        while (rightIndex<right.length){
            result[index] = right[rightIndex];
            rightIndex++;
            index++;
        }
        return result;
    }


    public static void main(String[] args){
//        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        int[] array = {5, 1, 7, 3, 1, 6, 9, 4};
        MergeSortAchieve mergeSortAchieve = new MergeSortAchieve();

        System.out.print("array before sort: ");
        mergeSortAchieve.show(array);

        int[] sortResult = mergeSortAchieve.mergeSort(array, 0 , array.length-1);
        System.out.print("array after sort: ");
        mergeSortAchieve.show(sortResult);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
