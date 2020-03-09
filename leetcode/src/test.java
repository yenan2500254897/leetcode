import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {
    public void change(int[][] input){
        input[0][1] = 1;
    }
    public void show(int[][] input){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                System.out.print(" " +input[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] input = {{1,0},{0,1}};
        test t=new test();
        t.show(input);
        t.change(input);
        t.show(input);
        /*
        System.out.println(list);
        for(String item:list){
            if(item.equals("2")){
                list.remove("2");
            }
        }
        System.out.println(list);*/
    }

}
