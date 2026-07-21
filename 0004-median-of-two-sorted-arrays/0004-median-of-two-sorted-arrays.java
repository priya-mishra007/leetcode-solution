class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num = nums1.length + nums2.length;
        int[] ans = new int[num];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nums1[i];

        }
        for (int i = 0; i < nums2.length; i++) {
            ans[nums1.length + i] = nums2[i];
        }
        Arrays.sort(ans);
        if (num % 2 == 0) {
            return (ans[num / 2 - 1] + ans[num / 2]) / 2.0;
        } else {
            return ans[((num + 1) / 2) - 1];
        }
    }
}