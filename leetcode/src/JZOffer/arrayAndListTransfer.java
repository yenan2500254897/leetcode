package JZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class arrayAndListTransfer {
    public void arrayAndListTransfer(){
        int[] ints = new int[10];
        Integer[] Integers = new Integer[10];
        List<Integer> list = new ArrayList<>(10);
        //Integer[] to int[]
        ints = Arrays.stream(Integers).mapToInt(Integer::valueOf).toArray();
        //int[] to Integer[]
        Integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);

        //List<Integer> to Integer[]
        Integers = list.toArray(new Integer[0]);

        //Integer[] to List<Integer>
        list = Arrays.asList(Integers);

        //List<Integer> to int[]
        ints = Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();

        //int[] to List<Integer>
        list = Arrays.stream(ints).boxed().collect(Collectors.toList());
    }
}
