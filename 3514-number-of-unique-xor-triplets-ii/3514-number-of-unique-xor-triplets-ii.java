class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(nums[i] ^ nums[j]);
            }
        }
        for(int x:set){
            for(int num:nums){
                ans.add(x ^ num);
            }
        }
        return ans.size();
    }
}