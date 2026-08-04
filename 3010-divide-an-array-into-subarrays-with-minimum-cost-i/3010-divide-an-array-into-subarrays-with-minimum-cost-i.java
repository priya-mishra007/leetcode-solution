class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int [] suffixMin = new int [n];
        suffixMin[n-1] = nums[n-1];
        for (int i = n-2 ; i>=0 ; i--){
            suffixMin[i] = Math.min(nums[i],suffixMin[i+1]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=n-2; i++){
            ans=Math.min(ans, nums[0]+nums[i]+suffixMin[i+1]);
        }
        return ans;
    }
}