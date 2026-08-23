class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();
        for (char c : s.toCharArray()) {
            String bits = Integer.toBinaryString(c);
            while (bits.length() < 8) {
                bits = "0" + bits;
            }
            binary.append(bits);
        }
        int left = 0;
        int right = binary.length() - 1;
        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}