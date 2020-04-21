package sort;

//插入排序实现
public class InsertionSortAchieve {

    public void insertionSort(int[] array){
        int len = array.length;

        for(int outter = 0;outter<len; outter++){
            int insertValue = array[outter];
            int inner =0;
            for(; inner<outter;inner++){
                if(array[inner]>insertValue){
                    break;
                }
            }

            //将inner开始的值都往后移
            for(int move = outter;move>inner;move--){
                if(move-1>=0){
                    array[move] = array[move-1];
                }
            }
            if(inner<len && inner!=outter){
                array[inner] = insertValue;
            }
        }
    }

    public static void main(String[] args){
        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        InsertionSortAchieve insertionSortAchieve = new InsertionSortAchieve();

        System.out.print("array before sort: ");
        insertionSortAchieve.show(array);

        insertionSortAchieve.insertionSort(array);
        System.out.print("array after sort: ");
        insertionSortAchieve.show(array);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
