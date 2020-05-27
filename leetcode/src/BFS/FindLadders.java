package BFS;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

public class FindLadders {

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> result = new ArrayList<String>();
        if(!wordList.contains(endWord)){
            return result;
        }

        int len = wordList.size();
        List<String> assistantList = new ArrayList<String>(4);
        assistantList.addAll(wordList);
        assistantList.add(beginWord);
        Map<String, List<String>> map = new HashMap<String, List<String>>(4);
        for(int i=0;i<assistantList.size();i++){
            for(int j=0;j<assistantList.size();j++){
                if(i!=j && isValid(assistantList.get(i), assistantList.get(j))){
                    if(!map.containsKey(assistantList.get(i))){
                        List<String> tempList = new ArrayList<String>(1);
                        tempList.add(assistantList.get(j));
                        map.put(assistantList.get(i), tempList);
                    }else {
                        List<String> preList = map.get(assistantList.get(i));
                        preList.add(assistantList.get(j));
                        map.put(assistantList.get(i), preList);
                    }
                }
            }
        }

        Queue<List<String>> queue = new ArrayDeque<List<String>>(4);
        Queue<List<String>> assistant = new ArrayDeque<List<String>>(4);

        //初始化
        List<String> initList = new ArrayList<String>(1);
        initList.add(beginWord);
        queue.add(initList);

        boolean flag = false;
        int step = 0;
        while (!queue.isEmpty()){

            List<String> currentList = queue.poll();
            //System.out.print(" current list: ");
            //show(currentList);
            if(currentList.size()<=len+1){
                String currentString = currentList.get(currentList.size()-1);
                if(currentString.equals(endWord)){
                    //System.out.print("finish list: ");
                    //show(currentList);
                    return currentList;
                }

                List<String> tempList = map.get(currentString);
                if(tempList!=null && tempList.size()>0){
                    for(String s: tempList){
                        if(!currentList.contains(s)){
                            List<String> temp = new ArrayList<String>(4);
                            temp.addAll(currentList);
                            temp.add(s);
                            assistant.add(temp);
                        }
                    }
                }

            }
            if(queue.isEmpty()){
                queue.addAll(assistant);
                assistant.clear();
            }
        }

        result = new ArrayList<String>(1);
        //System.out.print("fail list:");
        show(result);
        return result;
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
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        List<String> list = Arrays.asList(wordList);
        FindLadders findLadders = new FindLadders();
        List<String> result = findLadders.findLadders(beginWord, endWord, list);
        findLadders.show(result);
    }


}
