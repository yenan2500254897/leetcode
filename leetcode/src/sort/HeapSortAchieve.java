package sort;

public class HeapSortAchieve {

    //调整堆
    public void adjustHeap(int[] array, int start, int end){


        for(int index = 2*start+1; index<=end;index = 2*index+1){
            int temp = array[(index-1)/2];
            //找出子节点中值较大的节点
            if(index+1<=end && array[index+1]>array[index]){
                index++;
            }
            //比较父节点与子节点值的大小'
            //父节点值较大，则跳出
            if(temp>=array[index]){
                break;
            }

            //子节点值较大
            array[(index-1)/2] = array[index];
            array[index] = temp;

        }
        return;
    }

    public void heapSort(int[] array){
        int len = array.length;

        //构建大顶堆
        for(int circle = len/2 - 1;circle>=0;circle--){
            adjustHeap(array, circle, len-1);
        }

        //每次将堆顶元素放到最后一位
        for(int index = len-1;index>=0;index--){
            int temp = array[0];
            array[0] = array[index];
            array[index] = temp;

            adjustHeap(array, 0, index-1);
        }

        return;
    }

    public static void main(String[] args){
//        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        int[] array = {5, 1, 7, 3, 1, 6, 9, 4};
        HeapSortAchieve heapSortAchieve = new HeapSortAchieve();

        System.out.print("array before sort: ");
        heapSortAchieve.show(array);

        heapSortAchieve.heapSort(array);
        System.out.print("array after sort: ");
        heapSortAchieve.show(array);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
