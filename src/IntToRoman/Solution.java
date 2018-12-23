package IntToRoman;

class Solution {
    public String intToRoman(int num) {
        int[] ints = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuffer sb = new StringBuffer();
        
         while(num > 0){
             for(int i = 0;i < ints.length;){
                 if(num >= ints[i]){
                     sb.append(romans[i]);
                     num -= ints[i];
                 }
                 if (num < ints[i]) i++;
             }
         }
        
        return sb.toString();
    }
}