package common;

import java.util.List;

public class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode() {}

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, List<TreeNode> _children) {
        val = _val;
        children = _children;
    }
}