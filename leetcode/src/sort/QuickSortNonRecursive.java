package sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//快速排序的非递归实现
public class QuickSortNonRecursive {

    public void quickSort(int[] array, int start, int end){

        //存储下表用的辅助队列
        Queue<Integer> primaryQueue = new ArrayDeque<Integer>(2);
        Queue<Integer> assistantQueue = new ArrayDeque<Integer>(2);

        primaryQueue.add(start);
        primaryQueue.add(end);

        while (!primaryQueue.isEmpty()){
            int firstIndex = primaryQueue.poll();
            int lastIndex = primaryQueue.poll();

            int standardValue = array[firstIndex];

            int first = firstIndex + 1;
            int last = lastIndex;
            while (first<=last){
                if(array[first]<=standardValue){
                    first++;
                    continue;
                }

                if(array[last]>standardValue){
                    last--;
                    continue;
                }

                if(first<last){
                    int temp = array[first];
                    array[first] = array[last];
                    array[last] = temp;
                }
            }

            int tempVal = array[last];
            array[last] = standardValue;
            array[firstIndex] = tempVal;

            if(firstIndex < last-1){
                primaryQueue.add(firstIndex);
                primaryQueue.add(last-1);
            }

            if(first<lastIndex){
                primaryQueue.add(first);
                primaryQueue.add(lastIndex);
            }

        }

    }

    public static void main(String[] args){
//        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        int[] array = {5, 4, 3, 2, 1};
        QuickSortNonRecursive quickSortNonRecursive = new QuickSortNonRecursive();

        System.out.print("array before sort: ");
        quickSortNonRecursive.show(array);

        quickSortNonRecursive.quickSort(array, 0 , array.length-1);
        System.out.print("array after sort: ");
        quickSortNonRecursive.show(array);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
