package CloneGraph;

import common.Node;

import java.util.*;

/**
 * Runtime: 42 ms, faster than 7.96% of Java online submissions for Clone Graph.
 * Memory Usage: 39.1 MB, less than 5.88% of Java online submissions for Clone Graph.
 * Next challenges:
 * TODO 优化
 */
class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        return dfs(node, map);
    }

    public Node dfs(Node node, HashMap<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, map));
        }

        return newNode;
    }
}