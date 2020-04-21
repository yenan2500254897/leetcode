package sort;

//冒泡排序算法实现
public class BubbleSortAchieve {
    public static void bubbleSort(int[] array){
        int len = array.length;
        for(int outter = len-1;outter>=0;outter--){
            for(int inner = 0;inner<=outter;inner++){
                if(inner-1>=0 && array[inner-1]>array[inner]){
                    int temp = array[inner];
                    array[inner] = array[inner-1];
                    array[inner-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        BubbleSortAchieve bubbleSortAchieve = new BubbleSortAchieve();

        System.out.print("array before sort: ");
        bubbleSortAchieve.show(array);

        bubbleSortAchieve.bubbleSort(array);
        System.out.print("array after sort: ");
        bubbleSortAchieve.show(array);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }



}
