package common;

public class TreeUtil {
    public static BinaryTreeNode readTree(String string) {
        string = string.substring(1,string.length() - 1);
        String[] arr = string.split(",");

        BinaryTreeNode result = new BinaryTreeNode(Integer.parseInt(arr[0]));
        BinaryTreeNode currentNode = result;

//        for (int i = 1; i < arr.length; i++) {
//
//        }

        return null;
    }
}
