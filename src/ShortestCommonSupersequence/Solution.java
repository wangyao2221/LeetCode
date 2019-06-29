package ShortestCommonSupersequence;

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int n1 = 0;
        for (int i = 1; i <= (len1 > len2 ? len2 : len1); i++) {
            if (compareSubString(str1,str2,i)){
                n1 = i;
            }
        }

        int n2 = 0;
        for (int i = 1; i <= (len1 > len2 ? len2 : len1); i++) {
            if (compareSubString(str2,str1,i)){
                n2 = i;
            }
        }

        if (n1 > n2){
            return str1.substring(0,len1 - n1 + 1) + str2.substring(n1 - 1,len2);
        }else {
            return str2.substring(0,len2 - n2 + 1) + str1.substring(n2 - 1,len1);
        }
    }

    public boolean compareSubString(String str1,String str2,int n){
        int len1 = str1.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(len1 - n + i) != str2.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestCommonSupersequence("aba","abac"));
    }
}