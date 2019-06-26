public class BaiduInterview {
    public int finStrategyCount(String str){
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            result++;

            if (i + 1 < str.length()){
                int m = str.charAt(i + 1) - '0';
                int sum = n * 10 + m;

                if (sum < 26){
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BaiduInterview().finStrategyCount("126"));
    }
}
