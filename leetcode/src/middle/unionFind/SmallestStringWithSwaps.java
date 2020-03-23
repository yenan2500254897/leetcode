package middle.unionFind;

import utils.TransferToIntegerArray;

import java.util.*;

/**
 * 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 *
 */
public class SmallestStringWithSwaps {

    int[] father;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        initFather(len);
        for(List<Integer> item:pairs){
            item.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
        }
        pairs.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0)!=o2.get(0)){
                    return o1.get(0).compareTo(o2.get(0));
                }
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        //showInteger(pairs);
        for(List<Integer> list:pairs){
            int first = list.get(0);
            int second = list.get(1);
            System.out.println("first: " + first +" second " + second );
            union(first, second);
            System.out.print("father value:" );
            //show(father);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<len;i++){
            int tempFather = findFather(i);
            if(!map.containsKey(findFather(i))){
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(tempFather, set);
            }else{
                Set<Integer> set = map.get(tempFather);
                set.add(i);
                map.put(tempFather, set);
            }
        }
        List<List<Integer>> indexList = new ArrayList<>();
        List<List<Character>> charList = new ArrayList<>();
        for(Map.Entry<Integer,Set<Integer>> entry:map.entrySet()){
            List<Integer> integers = new ArrayList<>(entry.getValue());
            List<Character> characters = new ArrayList<>(transfer(s, integers));
            indexList.add(integers);
            charList.add(characters);
        }

        int circle = indexList.size();
        for(int i=0;i<circle;i++){
            indexList.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            charList.get(i).sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1.compareTo(o2);
                }
            });
        }
        //System.out.println("indexList: start");
        //showInteger(indexList);
        //System.out.println("charList: start");
        //showCharacter(charList);
        //showCharacter(charList);
        char[] result = new char[len];
        for(int i=0;i<circle;i++){
            int secCircle = indexList.get(i).size();
            for(int j=0;j<secCircle;j++){
                result[indexList.get(i).get(j)] = charList.get(i).get(j);
            }
        }
        return String.copyValueOf(result);
    }

    public void initFather(int n){
        father = new int[n];
        for(int index=0;index<n;index++){
            father[index] = index;
        }
    }

    public int findFather(int son){
        if(son == father[son]){
            return son;
        }
        return findFather(father[son]);
    }

    public void union(int pre, int next){
        if(findFather(pre) == findFather(next)){
            return;
        }
        father[findFather(next)] = pre;
    }

    public List<Character> transfer(String s, List<Integer> list){
        List<Character> characters = new ArrayList<>();
        for(Integer integer:list){
            characters.add(s.charAt(integer));
        }
        return characters;
    }

    public void showInteger(List<List<Integer>> lists){
        for(List<Integer> list:lists){
            for(Integer item:list){
                System.out.print(" " + item + " ");
            }
            System.out.println();
        }
    }

    public void showCharacter(List<List<Character>> lists){
        for(List<Character> list:lists){
            for(Character item:list){
                System.out.print(" " + item + " ");
            }
            System.out.println();
        }
    }

    public void show(int[] input){
        for(int item:input){
            System.out.print(" " + item + " ");
        }
        System.out.println();
    }

    public void replace(int pre, int next){
        int len = father.length;
        for(int i=0;i<len;i++){
            if(father[i] == next){
                father[i] = pre;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String s = "";
        String filePath = "C:\\Users\\yn\\IdeaProjects\\leetcode\\leetcode\\";
        String fileName = "test.txt";
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int[][] input = transferToIntegerArray.toTwoDimArray(filePath+fileName);
        List<List<Integer>> lists = new ArrayList<>();
        //transferToIntegerArray.showTwoDimArray(input);
        for(int[] item:input){
            List<Integer> list = new ArrayList<>();
            for(int i:item){
                list.add(i);
            }
            lists.add(list);
        }
        SmallestStringWithSwaps test = new SmallestStringWithSwaps();
        test.smallestStringWithSwaps(s, lists);
    }

}
