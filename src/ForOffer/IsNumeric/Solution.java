package ForOffer.IsNumeric;

public class Solution {
    public boolean isNumeric(char[] str) {
        if(str.length == 1) return false;
        int i = 0;
        if(str[0] == '-' || str[0] == '+') {
            if(str.length == 1) return false;
            i = 1;
        }
        
        boolean numPart = false;
        boolean expPart = false;
        boolean dot = false;
        
        while(i < str.length) {
            // 遇到任何不应该出现在数字里的字符直接返回false
            if(str[i] != 'e' && str[i] != 'E' && str[i] != '.' && 
               str[i] != '-' && str[i] != '+' && !(str[i] >= '0' && str[i] <= '9')) {
                return false;
            }
            
            // 底数部分还未开始时判断底数是否符合条件，是的话将底数标记置为ture
            if(!numPart) {
                if(str[i] >= '0' && str[i] <= '9' || str[i] == '.'){
                    numPart = true;
                } else {
                    return false;
                }
            } else if(numPart){
                if(!expPart) {
                    // 底数部分如果中间出现符号直接返回false
                    if(str[i] == '+' || str[i] == '-') return false;
                    
                    // 底数部分如果多次出现小数点直接返回false
                    if(!dot && str[i] == '.') dot = true;
                    else if(dot && str[i] == '.') return false;
                    
                    // 如果遇到e或E则表示指数部分开始了，并标记一下指数部分已经开始
                    if(str[i] == 'e' || str[i] == 'E') {
                        expPart = true;
                        // 如果指数数值部分没有值则直接返回false
                        if(i + 1 >= str.length) return false;
                        // 如果e或E后面不是符号也不是数字直接返回false
                        if(i + 1 < str.length && 
                           (str[i + 1] != '-' && str[i + 1] != '+') && 
                           (str[i + 1] < '0' && str[i + 1] > '9')) {
                            return false;
                        }
                        // 如果指数后面是符号则往后移动一位，下一次开始判断指数数值部分
                        if(i + 1 < str.length && 
                           (str[i + 1] == '-' || str[i + 1] == '+')) {
                            i++;
                        }
                    }
                } else {
                    if(str[i] < '0' || str[i] > '9') {
                        return false;
                    }
                }
            }
            i++;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isNumeric("12e+5.4".toCharArray());
    }
}