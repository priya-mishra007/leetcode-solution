class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone(); 
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int indexToDiscount = stack.pop();
                answer[indexToDiscount] -= prices[i];
            }
            stack.push(i);
        }
        return answer;
    }
}