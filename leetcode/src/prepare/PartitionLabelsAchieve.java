package prepare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabelsAchieve {

    public List<Integer> partitionLabels(String S) {
        int len = S.length();

        int startIndex = 0;
        List<Integer> list = new ArrayList<>(4);
        while (startIndex<len){
            int lastIndex = S.lastIndexOf(S.charAt(startIndex));

            //单独一个元素
            if(lastIndex == -1){
                list.add(1);
                startIndex++;
                continue;
            }

            //一直向右扩张，知道该区间的字母在其他区间不存在
            int recordIndex = startIndex;
            while (lastIndex<len && recordIndex<=lastIndex){
                boolean finded = S.substring(lastIndex+1).contains(S.substring(recordIndex, recordIndex+1));
                //index上的字母在lastIndex的右边没找到
                if(finded == false){
                    recordIndex++;
                }else {
                    //index上的字母在lastIndex的右边找到了，扩张右边界
                    lastIndex = S.lastIndexOf(S.charAt(recordIndex));
                }
            }
            list.add(lastIndex-startIndex+1);
            startIndex = lastIndex+1;
        }
        return list;
    }
}
