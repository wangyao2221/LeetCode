package ForOffer.ReverseSentence;

public class Solution {
    public String ReverseSentence(String str) {
        if(str.length() <= 1) return str;
        char[] charArr = str.toCharArray();
        reverse(charArr, 0, charArr.length - 1);
        int left = 0, right = 1;
        while(right < charArr.length) {
            if(charArr[right] == ' ') {
                reverse(charArr, left, right - 1);
                left = right + 1;
                right = left + 1;
            } else {
                right++;
            }
        }
        reverse(charArr, left, right - 1);
        return new String(charArr);
    }
    
    public void reverse(char[] arr, int low, int high) {
        while(low < high) {
            char tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ReverseSentence("I am a student."));
    }
}