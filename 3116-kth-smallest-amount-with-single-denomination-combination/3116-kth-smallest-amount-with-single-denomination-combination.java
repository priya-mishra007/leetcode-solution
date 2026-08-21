class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long[] lcm = new long[1 << n];
        lcm[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            long value = 1;
            boolean overflow = false;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    long g = gcd(value, coins[i]);
                    if (value > Long.MAX_VALUE / (coins[i] / g)) {
                        overflow = true;
                        break;
                    }
                    value = value / g * coins[i];
                }
            }
            lcm[mask] = overflow ? Long.MAX_VALUE : value;
        }
        long low = 1;
        long high = (long) min(coins) * k;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(mid, coins, lcm) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private long count(long x, int[] coins, long[] lcm) {
        long result = 0;
        for (int mask = 1; mask < lcm.length; mask++) {
            if (lcm[mask] > x)
                continue;
            long multiples = x / lcm[mask];
            if (Integer.bitCount(mask) % 2 == 1) {
                result += multiples;
            } else {
                result -= multiples;
            }
        }
        return result;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    private int min(int[] coins) {
        int min = coins[0];
        for (int coin : coins) {
            min = Math.min(min, coin);
        }
        return min;
    }
}