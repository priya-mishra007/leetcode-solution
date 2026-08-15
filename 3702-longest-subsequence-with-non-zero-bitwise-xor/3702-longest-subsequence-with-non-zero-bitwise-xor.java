class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean hasZero = false;
        for(int num : nums){
            xor ^= num;
            if(num != 0){
                hasZero = true;
            }
        }
        if(xor != 0){
            return nums.length;
        }
        return hasZero ? nums.length - 1 : 0;
    }
}