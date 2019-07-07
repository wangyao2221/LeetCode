package WeeklyContest144.DefangingAnIPAddress;

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address);

        for (int i = 0; i < sb.length();) {
            if (sb.charAt(i) == '.') {
                sb.insert(i + 1, ']');
                sb.insert(i, '[');
                i += 2;
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().defangIPaddr("255.100.50.0"));
    }
}