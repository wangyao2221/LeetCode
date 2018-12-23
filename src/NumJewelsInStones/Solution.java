package NumJewelsInStones;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        
        for(int i = 0;i < S.length();i++){
            String ch = "" + S.charAt(i);
            if(J.contains(ch)) result++;
        }
        
        return result;
    }
}