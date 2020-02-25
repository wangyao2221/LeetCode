package HappyNumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        
        while(true) {
            int tmpN = n;
            n = 0;
            while(tmpN != 0) {
                int remainder = tmpN % 10;
                n += remainder * remainder;
                tmpN /= 10;
            }
            if(n == 1) {
                return true;
            }
            if(!set.add(n)) return false;
        }
    }
}