package common;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static void show(Node node) {
        List<Integer> inQueue = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        nodeQueue.add(node);
        inQueue.add(node.val);
        while (!nodeQueue.isEmpty()) {
            Node tmpNode = nodeQueue.poll();

            System.out.print(tmpNode.val + ":");
            for (Node neighbor : tmpNode.neighbors) {
                System.out.print(" " + neighbor.val);
                if (!inQueue.contains(neighbor.val)) {
                    inQueue.add(neighbor.val);
                    nodeQueue.offer(neighbor);
                }
            }
            System.out.println();
        }
    }
}