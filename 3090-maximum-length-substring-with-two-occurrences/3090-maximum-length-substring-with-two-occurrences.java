class Solution {
    public int maximumLengthSubstring(String s) {
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a']++;
                if(freq[s.charAt(j) - 'a'] > 2)
                    break;
                maxlen = Math.max(maxlen, j - i + 1);
            }
        }
        return maxlen;
    }
}   