package BFS;

import java.util.*;

public class MaxCandies {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int total = 0;
        //初始状态为空
        if(initialBoxes == null || initialBoxes.length == 0){
            return total;
        }

        Queue<Box> queue = new ArrayDeque<Box>(4);
        Queue<Box> assistant = new ArrayDeque<Box>(4){
            @Override
            public boolean contains(Object o) {
                Box currentBox = (Box) o;
                for(Box box:this){
                    if(box.boxId == currentBox.boxId){
                        return true;
                    }
                }
                return false;
            }
        };

        Queue<Box> already = new ArrayDeque<Box>(4){
            @Override
            public boolean contains(Object o) {
                Box currentBox = (Box) o;
                for(Box box:this){
                    if(box.boxId == currentBox.boxId){
                        return true;
                    }
                }
                return false;
            }
        };
        Set<Integer> keySet = new HashSet<Integer>(4);

        //初始化
        for(int i=0;i<initialBoxes.length;i++){
            int boxId = initialBoxes[i];
            int boxStauts = status[boxId];
            int candyCount = candies[boxId];
            int[] keyArray = keys[boxId];
            int[] containedBoxesArray = containedBoxes[boxId];

            Box box = new Box(boxId, boxStauts, candyCount, keyArray, containedBoxesArray);

            //将打开的盒子的钥匙放入keySet
            if(boxStauts == 1 || (boxStauts == 0 && keySet.contains(boxId))){
                for(int j=0;j<keyArray.length;j++){
                    keySet.add(keyArray[j]);
                }
            }
            queue.add(box);
        }

        //判断当前是否有新的盒子打开的标志
        boolean flag = true;
        while (!queue.isEmpty() && flag){
            //当前盒子
            Box currentBox = queue.poll();
            //show(currentBox);
            //盒子是关着的，且无钥匙
            if(currentBox.status == 0 && !keySet.contains(currentBox.boxId)){
                if(!assistant.contains(currentBox)){
                    assistant.add(currentBox);
                }
                //System.out.println("box: " + currentBox.boxId + " can't open");
                flag = false;
            }else {
                flag = true;
                already.add(currentBox);
                //盒子是开的，或者盒子是关的但是有钥匙
                //先拿出糖果
                total += currentBox.candyCount;
                //System.out.println("box: " + currentBox.boxId + " open, currentCandiesTotal: " + total);
                //将包含的盒子拿出来
                for(int index:currentBox.containedBoxesArray){
                    Box temp = new Box(index, status[index], candies[index], keys[index], containedBoxes[index]);
                    if(!assistant.contains(temp) && !already.contains(temp)){
                        assistant.add(temp);
                        //System.out.println("add box: " + index);
                        //拿出包含的钥匙
                        if(status[index]==1 ||(status[index] == 0 && keySet.contains(index))){
                            for(int tempKey:keys[index]){
                                keySet.add(tempKey);
                            }
                        }
                    }


                }
            }

            if(queue.isEmpty()){
                //System.out.println("queue is empty, add assistant to queue");
                queue.addAll(assistant);
                assistant.clear();
            }

        }
        return total;

    }


    public class Box{
        private int boxId;
        private int status;
        private int candyCount;
        private int[] keyArray;
        private int[] containedBoxesArray;

        Box(int boxId, int status, int candyCount, int[] keyArray, int[] containedBoxesArray){
            this.boxId = boxId;
            this.status = status;
            this.candyCount = candyCount;
            this.keyArray = keyArray;
            this.containedBoxesArray = containedBoxesArray;
        }
    }

    public void show(Box box){
        System.out.println("boxid: " + box.boxId + " status: " + box.status + " candyCount: " + box.candyCount );
    }
    public static void main(String[] args){
        int[] status = {1,0,1,0};
        int[] candies = {7,5,4,100};
        int[][] keys ={{},{},{1},{}};
        int[][] containedBoxes = {{1,2},{3},{},{}};
        int[] initialBoxes = {0};
        MaxCandies maxCandies = new MaxCandies();
        System.out.println(maxCandies.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}
