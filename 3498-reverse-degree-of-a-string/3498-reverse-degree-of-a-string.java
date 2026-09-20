class Solution {
    public int reverseDegree(String s) {
        int totalDegree = 0;
        for (int i = 0; i < s.length(); i++) {
            int reversedPosition = 26 - (s.charAt(i) - 'a');
            int stringPosition = i + 1;
            totalDegree += reversedPosition * stringPosition;
        }
        return totalDegree;
    }
}