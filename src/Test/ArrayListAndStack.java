package Test;

import java.util.ArrayList;
import java.util.Stack;

public class ArrayListAndStack {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            list.add(i);
//        }
//        long end = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            list.remove(list.size() - 1);
//        }
//
//        System.out.println(end - start);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10000000; i++) {
            stack.pop();
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
