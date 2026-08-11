class Solution {
    public int missingInteger(int[] nums) {
        boolean[] re = new boolean[51];
        int n = nums.length;
        int ans = nums[0];
        for(int i = 0; i < n; i++){
            re[nums[i]] = true;
        }
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i - 1] + 1)
                break;
            ans += nums[i];
        }
        while(ans <= 50 && re[ans]){
            ans++;
        }
        return ans;
    }
}