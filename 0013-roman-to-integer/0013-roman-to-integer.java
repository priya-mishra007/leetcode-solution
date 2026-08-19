class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int currentValue = 0;
            if (current == 'I')
                currentValue = 1;
            else if (current == 'V')
                currentValue = 5;
            else if (current == 'X')
                currentValue = 10;
            else if (current == 'L')
                currentValue = 50;
            else if (current == 'C')
                currentValue = 100;
            else if (current == 'D')
                currentValue = 500;
            else if (current == 'M')
                currentValue = 1000;
            int nextValue = 0;
            if (i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                if (next == 'I')
                    nextValue = 1;
                else if (next == 'V')
                    nextValue = 5;
                else if (next == 'X')
                    nextValue = 10;
                else if (next == 'L')
                    nextValue = 50;
                else if (next == 'C')
                    nextValue = 100;
                else if (next == 'D')
                    nextValue = 500;
                else if (next == 'M')
                    nextValue = 1000;
            }
            if (currentValue < nextValue)
                result -= currentValue;
            else
                result += currentValue;
        }
        return result;
    }
}