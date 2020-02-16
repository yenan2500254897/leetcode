import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {

    public static void main(String[] args){
        List<String> list = new ArrayList<>(2);
        list.add("1");
        list.add("2");

        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String temp =(String)iterator.next();
            if(temp.equals("1")){
                iterator.remove();
            }
        }
        System.out.println(list);

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
