class Solution {
    public int maximumProduct(int[] n) {
        Arrays.sort(n);
        int product1 = n[n.length - 1] * n[n.length - 2] * n[n.length - 3];
        int product2 = n[0] * n[1] * n[n.length - 1];
        return Math.max(product1, product2);
    }
}