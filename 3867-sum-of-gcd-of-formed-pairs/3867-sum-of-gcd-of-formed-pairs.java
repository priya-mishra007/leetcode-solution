class Solution {
    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];

        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }
        Arrays.sort(prefixGcd);
        int left = 0, right = nums.length - 1;
        long ans = 0;
        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return ans;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}