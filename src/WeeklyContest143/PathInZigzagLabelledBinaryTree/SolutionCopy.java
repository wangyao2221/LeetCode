package WeeklyContest143.PathInZigzagLabelledBinaryTree;

import java.util.ArrayList;
import java.util.List;

class SolutionCopy {

    public static void main(String[] args) {
        List<Integer> result = new SolutionCopy().pathInZigZagTree(16);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        int high = 0;
        int index = label;

        while (index > 0){
            result.add(0,index);
            if (index % 2 != 0){
                index = (index - 1) / 2;
            }else {
                index = index / 2;
            }
        }

        if (result.size() % 2 == 0) {
            for (int i = 2; i < result.size() - 1; i+=2) {
                if (i % 2 == 0){
                    int rowMax = (int) Math.pow(2,i + 1) - 1;
                    int rowMin = rowMax - (int)Math.pow(2,i) + 1;
                    result.set(i,rowMin + (rowMax - result.get(i)));
                }

            }
        }else {
            for (int i = 1; i < result.size() - 1; i+=2) {
                if (i % 2 != 0){
                    int rowMax = (int) Math.pow(2,i + 1) - 1;
                    int rowMin = rowMax - (int)Math.pow(2,i) + 1;
                    result.set(i,rowMin + (rowMax - result.get(i)));
                }

            }
        }

        return result;
    }
}