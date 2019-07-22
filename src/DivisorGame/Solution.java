package DivisorGame;

class Solution {
    // 10 5 4 3 2
    // 5 1 1
    // 1 1
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divisorGame(3 ));
    }
}