package middle;

import java.util.*;

/**
 * 5305. 获取你好友已观看的视频
 *
 * 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
 *
 * 给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
 *
 * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
 *
 * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按名字字典序从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * 输出：["B","C"]
 * 解释：
 * 你的 id 为 0 ，你的朋友包括：
 * id 为 1 -> watchedVideos = ["C"] 
 * id 为 2 -> watchedVideos = ["B","C"] 
 * 你朋友观看过视频的频率为：
 * B -> 1 
 * C -> 2
 * 示例 2：
 *
 *
 *
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * 输出：["D"]
 * 解释：
 * 你的 id 为 0 ，你朋友的朋友只有一个人，他的 id 为 3 。
 *  
 *
 * 提示：
 *
 * n == watchedVideos.length == friends.length
 * 2 <= n <= 100
 * 1 <= watchedVideos[i].length <= 100
 * 1 <= watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j] < n
 * 0 <= id < n
 * 1 <= level < n
 * 如果 friends[i] 包含 j ，那么 friends[j] 包含 i
 *
 */
public class watchedVideosByFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> result = new ArrayList<>();

        if(friends.length!=0){
            List<List<Integer>> convertFriends = new ArrayList<>();
            for(int[] item: friends){
                List<Integer> tempList = new ArrayList<>();
                for(int number: item){
                    tempList.add(number);
                }
                convertFriends.add(tempList);
            }

            HashSet<Integer> start = new LinkedHashSet<>(convertFriends.get(id));
            HashSet<Integer> record = new LinkedHashSet<>();
            record.add(id);
            boolean flag = true;
            level--;
            while (level>0){
                start.removeAll(record);
                level--;
                HashSet<Integer> tempSet = new LinkedHashSet<>();
                for(Integer index : start){
                    tempSet.addAll(convertFriends.get(index));
                }
                record.addAll(start);
                start.clear();
                start.addAll(tempSet);
                start.removeAll(record);
            }

            HashMap<String, Integer> map = new HashMap();
            for(Integer item: start){
                for(String s: watchedVideos.get(item)){
                    if(!map.containsKey(s)){
                        map.put(s, 1);
                        continue;
                    }
                    int count = map.get(s);
                    map.put(s, count+1);
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o1.getValue().equals(o2.getValue())){
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            for(Map.Entry<String, Integer> item : list){
                //System.out.println(item.getKey() + " value: "+ item.getValue());
                result.add(item.getKey());
            }
        }
        return result;
    }
}
