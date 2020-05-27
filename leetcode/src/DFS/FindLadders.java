package DFS;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class FindLadders {

    Map<String, List<String>> map;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> result = new ArrayList<String>();
        if(!wordList.contains(endWord)){
            return result;
        }

        List<String> assistant = new ArrayList<String>(4);
        assistant.addAll(wordList);

        if(!assistant.contains(beginWord)){
            assistant.add(beginWord);
        }

        map = new HashMap<String, List<String>>(1);
        for(int i=0;i<assistant.size();i++){
            String pre = assistant.get(i);
            for(int j=0;j<assistant.size();j++){
                String next = assistant.get(j);
                if(isValid(pre, next)){
                    if(!map.containsKey(pre)){
                        List<String> initList = new ArrayList<String>(1);
                        initList.add(next);
                        map.put(pre, initList);
                    }else {
                        List<String> existList = map.get(pre);
                        existList.add(next);
                        map.put(pre, existList);
                    }
                }
            }
        }
        result.add(beginWord);
        wordList.remove(beginWord);
        return dfs(endWord, result, wordList);
    }

    public List<String> dfs(String endWord, List<String> currentList, List<String> reserveList){
        String currentWord = currentList.get(currentList.size()-1);
        System.out.println("currentWord: " + currentWord);
        if(currentWord.equals(endWord)){
            return currentList;
        }

        if(reserveList.isEmpty()){
            System.out.println("remove word: " + currentWord);
            currentList.remove(currentWord);
            return currentList;
        }

        List<String> similarList = map.get(currentWord);
        if(similarList == null || similarList.isEmpty()){
            System.out.println("remove word: " + currentWord);
            currentList.remove(currentWord);
            return currentList;
        }
        for(String nextStr: similarList){
            if(reserveList.contains(nextStr)){
                System.out.println(" nextStr: " + nextStr);
                currentList.add(nextStr);
                reserveList.remove(nextStr);
                List<String> list = dfs(endWord, currentList, reserveList);
                if(list.get(list.size()-1).equals(endWord)){
                    return list;
                }
            }
        }
        currentList.remove(currentWord);
        return currentList;
    }

    public boolean isValid(String pre, String next){
        int diff = 0;
        for(int i=0;i<pre.length();i++){
            if(diff>1){
                return false;
            }
            if(pre.charAt(i) != next.charAt(i)){
                diff++;
            }
        }
        return diff==1?true:false;

    }

    public void show(List<String> list){
        for(String s:list){
            System.out.print(" " + s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        String beginWord = "hot";
        String endWord = "dog";
        String[] wordList = {"hot","dog","dot"};

//        String beginWord = "qa";
//        String endWord = "sq";
//        String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> list = new ArrayList<String>(4);

        for(String s:wordList){
            list.add(s);
        }
        FindLadders findLadders = new FindLadders();
        findLadders.show(findLadders.findLadders(beginWord, endWord, list));

    }


}
