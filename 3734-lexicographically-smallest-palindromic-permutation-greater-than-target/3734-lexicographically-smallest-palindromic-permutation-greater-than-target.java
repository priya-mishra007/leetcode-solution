class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;
        int[] cnt = new int[26];

        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        int odd = 0, mid = -1;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1)
            return "";

        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++)
            halfCnt[i] = cnt[i] / 2;

        String targetHalf = target.substring(0, half);
        int[] freq = halfCnt.clone();

        boolean canMatch = true;

        for (int i = 0; i < half; i++) {
            int x = targetHalf.charAt(i) - 'a';

            if (freq[x] == 0) {
                canMatch = false;
                break;
            }

            freq[x]--;
        }

        if (canMatch) {
            String candidate = build(targetHalf, mid);

            if (candidate.compareTo(target) > 0)
                return candidate;
        }

        for (int i = half - 1; i >= 0; i--) {
            int[] f = halfCnt.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = targetHalf.charAt(j) - 'a';

                if (f[x] == 0) {
                    possible = false;
                    break;
                }

                f[x]--;
            }

            if (!possible)
                continue;

            int x = targetHalf.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (f[c] == 0)
                    continue;

                f[c]--;

                StringBuilder left = new StringBuilder();

                left.append(targetHalf, 0, i);
                left.append((char)('a' + c));

                for (int j = 0; j < 26; j++) {
                    while (f[j] > 0) {
                        left.append((char)('a' + j));
                        f[j]--;
                    }
                }

                return build(left.toString(), mid);
            }
        }

        return "";
    }

    private String build(String left, int mid) {
        StringBuilder ans = new StringBuilder(left);

        if (mid != -1)
            ans.append((char)('a' + mid));

        for (int i = left.length() - 1; i >= 0; i--)
            ans.append(left.charAt(i));

        return ans.toString();
    }
}