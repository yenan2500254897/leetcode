package sort;

//快速排序递归实现
public class QuickSortRecursive {

    //4 1 5 3 7 2
    private void quickSort(int[] array, int start, int end){
        if(start>=end){
            return;
        }
        int compareValue = array[start];

        int first = start+1;
        int last =end;
        while (last>=first){
            if(array[first] <= compareValue){
                first++;
                continue;
            }

            if(array[last] > compareValue){
                last--;
                continue;
            }

            if(first<last){
                int temp = array[first];
                array[first] = array[last];
                array[last] = temp;
            }
        }

        int tmp = array[last];
        array[last] = array[start];
        array[start] = tmp;

        quickSort(array, start, last-1);
        quickSort(array, first, end);

    }

    public static void main(String[] args){
//        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        int[] array = {5, 4, 3, 2, 1};
        QuickSortRecursive quickSortRecursive = new QuickSortRecursive();

        System.out.print("array before sort: ");
        quickSortRecursive.show(array);

        quickSortRecursive.quickSort(array, 0 , array.length-1);
        System.out.print("array after sort: ");
        quickSortRecursive.show(array);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
