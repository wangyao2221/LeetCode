package WeeklyContest147.AlphabetBoardPath;

class Solution {
    public String alphabetBoardPath(String target) {
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            int ch = target.charAt(i) - 'a';
            int newy = ch / 5;
            int newx = ch % 5;

            if (y < newy) {
                for (int j = 0; j < (newy == 5 ? newy - y - 1: newy - y); j++) {
                    sb.append('D');
                }
            } else {
                for (int j = 0; j < y - newy; j++) {
                    sb.append('U');
                }
            }

            if (x < newx) {
                for (int j = 0; j < newx - x; j++) {
                    sb.append('R');
                }
            } else {
                for (int j = 0; j < x - newx; j++) {
                    sb.append('L');
                }
            }

            if (y < newy && newy == 5) {
                sb.append("D");
            }

            sb.append('!');

            y = newy;
            x = newx;
        }

        return sb.toString();
    }

    /**
     * 输入：
     * "zdz"
     * 输出：
     * "DDDDD!UUUUURRR!DDDDDLLL!"
     * 预期：
     * "DDDDD!UUUUURRR!DDDDLLLD!"
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Solution().alphabetBoardPath("zdz"));
    }
}