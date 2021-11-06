package interview.aiqiyi;

import java.util.*;

public class BoxPlacing {
    /**
     *
     * @param boxes 储存所有盒子对应的边长
     * @return 装完盒子后，能看到的最小数量的盒子
     */
    public int fun(int[] boxes){
        List<Integer> boxList = new ArrayList<>();
        for (int i = 0; i < boxes.length; i++){
            boxList.add(boxes[i]);
        }
        Collections.sort(boxList);
        int i = 0;
        while (i < boxList.size() - 1){
            if (boxList.get(i) < boxList.get(i + 1)){
                boxList.remove(i);
            }else {
                i++;
            }
        }


        return boxList.size();
    }

    /**
     * 找出现数量最多的盒子个数，刚好就是答案
     * 例如，
     * 1 ####
     * 2 ##
     * 3 #####
     * 4 ###
     * 四种边长的盒子1，2，3，4，从左边对齐放置，第一个列的盒子1，2，3，4可以一次套进。同理，第二列。。。第五列。
     * 最后，每一列都有一个盒子，所以是5个盒子，和边长为3的盒子个数相同
     * @param boxes
     */
    public int fun1(int[] boxes){
        Map<Integer, Integer> boxFrequen = new HashMap<>();
        for (int i = 0; i < boxes.length; i++) {
            int curt = boxes[i];
            if (!boxFrequen.containsKey(curt)){
                boxFrequen.put(curt, 1);
            }else boxFrequen.put(curt, boxFrequen.get(curt) + 1);
        }

        int result = 0;
        for (Integer i:boxFrequen.values()
             ) {
            result = Math.max(result, i);
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] boxes = new int[n];
//        for (int i = 0; i < n; i++){
//            boxes[i] = in.nextInt();
//        }
//
//        BoxPlacing m = new BoxPlacing();
//        System.out.println(m.fun(boxes));
        int[] boxes = {1, 2, 3};
        System.out.println(new BoxPlacing().fun(boxes));
        System.out.println(new BoxPlacing().fun1(boxes));
    }
}
