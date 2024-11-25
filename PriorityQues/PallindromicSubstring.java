class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) { 
                String substring = s.substring(i, j);
                if (isP(substring)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isP(String str) {
        StringBuilder sb = new StringBuilder(str);
        String check = sb.reverse().toString();
        return check.equals(str);
    }
}
