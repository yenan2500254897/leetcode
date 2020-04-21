package sort;

//希尔排序实现
public class ShellSortAchieve {

    public void shellSort(int[] array){
        int len = array.length;

        //步长
        for(int step = (len+1)/2; step>0; step=step/2){

            //在一个步长中选取起始元素
            for(int outter=0;outter<step;outter++){
                int inner = outter;
                //一个步长区间
                while (inner<len){
                    int recordValue = array[inner];
                    int circle = inner-step;

                    //给一个步长区间排序
                    while (circle>=0 && array[circle]>recordValue){
                        array[circle+step] = array[circle];
                        circle = circle-step;
                    }
                    array[circle+step] = recordValue;
                    inner += step;
                }
            }
        }
    }

    public static void main(String[] args){
//        int[] array = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        int[] array = {5, 1, 7, 3, 1, 6, 9, 4};
        ShellSortAchieve shellSortAchieve = new ShellSortAchieve();

        System.out.print("array before sort: ");
        shellSortAchieve.show(array);

        shellSortAchieve.shellSort(array);
        System.out.print("array after sort: ");
        shellSortAchieve.show(array);

    }

    public void show(int[] array){
        for(int item: array){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
