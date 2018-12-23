package RomanToInt;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> romanIntMap = new HashMap<Character,Integer>();

        romanIntMap.put('I',1);
        romanIntMap.put('V',5);
        romanIntMap.put('X',10);
        romanIntMap.put('L',50);
        romanIntMap.put('C',100);
        romanIntMap.put('D',500);
        romanIntMap.put('M',1000);
        
        int result = 0;
        
        for(int i = 0;i < s.length() - 1;i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            int num1 = romanIntMap.get(ch1);
            int num2 = romanIntMap.get(ch2);
            
            if(num1 < num2){
                result -= num1; 
            }else {
                result += num1;
            }
        }

        int end = s.length() - 1;
        char endCh = s.charAt(end);
        result +=  romanIntMap.get(endCh);
        
        return result;
    }
}