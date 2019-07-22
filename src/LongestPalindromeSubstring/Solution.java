package LongestPalindromeSubstring;

/**
  * ע������⣺
  * 1����s�ĳ���Ϊ1ʱ
  * 2�������ҵ���һ���Գ��ҵ��ͷ��أ���Ҫ����������ҶԱȳ��Ⱥ󷵻أ���if(j - i + 1 > result.length())
  */
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return s;
        
        String result = "";
        
        for(int i = 0;i < s.length();i++){
            for(int j = s.length() - 1;j > i;j--){
                int start_tmp = i;
                int end_tmp = j;
                while(start_tmp < end_tmp){
                    if(s.charAt(start_tmp) == s.charAt(end_tmp)){
                        start_tmp++;
                        end_tmp--;
                    }else{
                        break;
                    }
                    
                    if(start_tmp >= end_tmp){
                        if(j - i + 1 > result.length()){
                            result = s.substring(i,j + 1);
                        }
                    }
                }
            }
        }
        
        if("".equals(result)){
            return s.length() > 0 ? s.substring(0,1) : "";
        }
        
        return result;
    }
}