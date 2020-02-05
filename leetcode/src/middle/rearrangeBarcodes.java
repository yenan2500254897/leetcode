package middle;

/**
 * 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 *
 * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 *
 * 输入：[1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 *  
 *
 * 提示：
 *
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 *
 */
public class rearrangeBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] result = new int[len];
        if(len==0){
            return result;
        }
        int[] total = new int[10001];
        for(int item:barcodes){
            total[item]++;
        }

        int maxValue = 0;
        int maxCount = total[0];
        for(int index = 0;index<len;index++){
            if(total[index]>maxCount){
                maxCount = total[index];
                maxValue = index;
            }
        }

        int pos = 0;
        int circle = 0;
        while (total[maxValue]>0){
            result[pos] = maxValue;
            pos += 2;
            total[maxValue]--;
        }

        int next = 0;
        while(pos<len){
            if(total[next] > 0){
                while (total[next]>0 && pos<len){
                    result[pos] = next;
                    total[next]--;
                    pos+=2;
                }
            }
            next++;
        }

        int odd = 1;
        for(int i =1;i<len;i++){
            while(total[i]>0){
                result[odd] = i;
                total[i]--;
                odd+=2;
            }
        }
        return result;
    }
}
