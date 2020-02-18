package CloneGraph;

import java.util.*;
import common.Node;

class Solution {
    public Node cloneGraph(Node node) {
        Node result = new Node();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        nodeQueue.offer(node);
        result.val = node.val;
        nodeMap.put(result.val, result);

        while (!nodeQueue.isEmpty()) {
            Node tmpNode = nodeQueue.peek();
            Node tmpNewNode = null;

            if (nodeMap.containsKey(tmpNode.val)) {
                tmpNewNode = nodeMap.get(tmpNode.val);
            } else {
                tmpNewNode = new Node();
                tmpNewNode.val = tmpNode.val;
                tmpNewNode.neighbors = new ArrayList<>();
                nodeMap.put(tmpNewNode.val, tmpNewNode);
            }

            List<Node> neighbors = tmpNode.neighbors;
            for (Node neighbor : neighbors) {
                Node newChild = null;

                if (nodeMap.containsKey(neighbor.val)) {
                    newChild = nodeMap.get(neighbor.val);
                } else {
                    newChild = new Node();
                    newChild.val = neighbor.val;
                    newChild.neighbors = new ArrayList<>();
                    nodeMap.put(newChild.val, newChild);
                }

//                if (!tmpNewNode.children.contains(newChild)) {
                tmpNewNode.neighbors.add(newChild);
                nodeQueue.offer(newChild);
//                }
            }
        }

        return result;
    }
}