package Test;

public class NumberToStringCount {
    public int count(String number) {
        int[] dp = new int[number.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= number.length(); i++) {
            int num1 = number.charAt(i - 2) - '0';
            int num2 = number.charAt(i - 1) - '0';
            int sum = num1 * 10 + num2;

            if(sum <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[number.length()];
    }

    public static void main(String[] args) {
        String str = "1227";
        System.out.println(new NumberToStringCount().count(str));
    }
}
