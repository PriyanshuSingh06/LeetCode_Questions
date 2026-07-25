class Solution {
   public int romanToInt(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int i) {
        if (i >= s.length()) {
            return 0;
        }

        int curr = romanValue(s.charAt(i));

        // Check if there is a next character
        if (i + 1 < s.length()) {
            int next = romanValue(s.charAt(i + 1));

            // Subtractive case (IV, IX, XL, XC, CD, CM)
            if (curr < next) {
                return next - curr + helper(s, i + 2);
            }
        }

        // Normal case
        return curr + helper(s, i + 1);
    }

    private int romanValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}