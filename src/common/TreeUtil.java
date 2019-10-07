package common;

public class TreeUtil {
    public static TreeNode readTree(String string) {
        string = string.substring(1,string.length() - 1);
        String[] arr = string.split(",");

        TreeNode result = new TreeNode(Integer.parseInt(arr[0]));
        TreeNode currentNode = result;

//        for (int i = 1; i < arr.length; i++) {
//
//        }

        return null;
    }
}
