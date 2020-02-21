package common.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            Wrapper.TreeNode root = Wrapper.stringToTreeNode(line);
            Wrapper.prettyPrintTree(root);
        }
    }
}