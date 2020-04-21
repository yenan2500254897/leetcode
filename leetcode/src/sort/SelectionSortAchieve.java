package sort;

//选择排序实现
public class SelectionSortAchieve {

    public void selectionSort(int[] array){
        int len = array.length;

        for(int outter = 0;outter<len;outter++){
            int minVal = array[outter];
            int minValIndex = outter;
            for(int inner = outter+1; inner<len; inner++){
                if(array[inner]<minVal){
                    minVal = array[inner];
                    minValIndex = inner;
                }
            }
            array[minValIndex] = array[outter];
            array[outter] = minVal;
        }
    }


    public static void main(String[] args){
        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        SelectionSortAchieve selectionSortAchieve = new SelectionSortAchieve();

        System.out.print("array before sort: ");
        selectionSortAchieve.show(array);

        selectionSortAchieve.selectionSort(array);
        System.out.print("array after sort: ");
        selectionSortAchieve.show(array);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
