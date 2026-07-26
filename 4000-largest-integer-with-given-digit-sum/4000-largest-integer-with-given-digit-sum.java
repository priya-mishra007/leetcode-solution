class Solution {
    public int largestInteger(int n, int s) {
        if (s > 9 * n)
            return -1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s >= 9) {
                ans.append(9);
                s -= 9;
            } else {
                ans.append(s);
                s = 0;
            }
        }
        return Integer.parseInt(ans.toString());
    }
}