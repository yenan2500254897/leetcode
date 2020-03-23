package middle;

import java.util.*;

/**
 * 1310. 子数组异或查询
 *
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 *
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 *
 */
public class xorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        List<Integer> inputNumber = new ArrayList<Integer>();
        for(int item: arr){
            inputNumber.add(item);
        }

        List<List<Integer>> queryList = new ArrayList<>();
        List<List<Integer>> test = new ArrayList<>();
        int k = 0;
        for(int[] item: queries){
            List<Integer> temp = new ArrayList<>();
            temp.add(item[0]);
            temp.add(item[1]);
            queryList.add(temp);
            test.add(temp);
        }


        Collections.sort(queryList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0).intValue()!=o2.get(0).intValue()){
                    return o1.get(0).compareTo(o2.get(0));
                }
                return o1.get(1).compareTo(o2.get(1));
            }
        });

        List<Integer> result = new ArrayList<>(queries.length);
        for(int i=0;i<queries.length;i++){
            result.add(-1);
        }
        //queries[i] = A[k,l], 计算出k==l或者l=k+1的输出
        for(int index = 0;index<queryList.size();index++){
            if(queryList.get(index).get(0).intValue() == queryList.get(index).get(1).intValue()){
                result.set(index, inputNumber.get(queryList.get(index).get(0)));
            }
            if(queryList.get(index).get(0).intValue()+1 == queryList.get(index).get(1).intValue()){
                result.set(index, inputNumber.get(queryList.get(index).get(0)) ^ inputNumber.get(queryList.get(index).get(1)));
            }
        }
        result = find(result, queryList, inputNumber);
        int[] res = new int[result.size()];
        for(int index = 0; index<result.size();index++){
            res[index] = result.get(queryList.indexOf(test.get(index)));
        }
        return res;

    }

    public List<Integer> find(List<Integer> result, List<List<Integer>> queryList, List<Integer> inputNumber){
        int len = queryList.size();
        for(int index = 0;index<len;index++){
            if(result.get(index) == -1){
                int front = index - 1;
                int calResult = 0;
                if(front >=0 && queryList.get(index).get(0) == queryList.get(front).get(0)){
                    System.out.println("go there 2");
                    int start = queryList.get(front).get(1)+1;
                    int end = queryList.get(index).get(1);
                    calResult = result.get(front);
                    System.out.println("calResult: " + calResult);
                    for(int circle = start;circle<=end;circle++){
                        calResult ^= inputNumber.get(circle);
                        System.out.println("circle: " + circle);
                    }
                }else {
                    int start = queryList.get(index).get(0);
                    int end = queryList.get(index).get(1);
                    for(int circle = start;circle<=end;circle++){
                        calResult ^= inputNumber.get(circle);
                    }
                }
                result.set(index, calResult);
                System.out.println("calResult: " + calResult);
            }
        }
        return result;
    }

    public int[] xorQueries2(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] middleResult = new int[len];
        for(int index = 0;index<len;index++){
            if(index == 0){
                middleResult[index] = 0;
                continue;
            }
            middleResult[index] = middleResult[index - 1] ^ arr[index];
        }

        int queriesLen = queries.length;
        int[] result = new int[queriesLen];
        for(int index = 0;index<queriesLen;index++){
            int left = queries[index][0];
            int right = queries[index][1] + 1;
            result[index] = middleResult[left] ^ middleResult[right];
        }
        return result;
    }
    }
