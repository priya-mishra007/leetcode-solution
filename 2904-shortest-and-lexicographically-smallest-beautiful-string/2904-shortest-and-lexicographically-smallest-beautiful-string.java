class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] pos = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pos[count++] = i;
            }
        }
        if (count < k) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i + k - 1 < count; i++) {
            int start = pos[i];
            int end = pos[i + k - 1];
            int len = end - start + 1;
            String cur = s.substring(start, end + 1);
            if (len < minLen) {
                minLen = len;
                ans = cur;
            } 
            else if (len == minLen && cur.compareTo(ans) < 0) {
                ans = cur;
            }
        }
        return ans;
    }
}