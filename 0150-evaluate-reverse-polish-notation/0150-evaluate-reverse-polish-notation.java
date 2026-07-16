class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens){
            switch(token){
                case "+":
                int b1 = s.pop();
                int a1 = s.pop();
                s.push(a1 + b1);
                break;
                case "-":
                int b2 = s.pop();
                int a2 = s.pop();
                s.push(a2 - b2);
                break;
                case "*":
                int b3 = s.pop();
                int a3 = s.pop();
                s.push(a3 * b3);
                break;
                case "/":
                int b4 = s.pop();
                int a4 = s.pop();
                s.push(a4 / b4);
                break;
                default:
                s.push(Integer.parseInt(token));
                                    
            }
        }
        return s.pop();
    }
}