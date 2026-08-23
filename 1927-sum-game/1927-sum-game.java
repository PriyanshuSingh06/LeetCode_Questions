class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int diff = 0;
        int leftQ = 0;
        int rightQ = 0;

        // Left half
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                diff += c - '0';
            }
        }

        // Right half
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                diff -= c - '0';
            }
        }

        // Odd number of '?' means Alice gets one extra move.
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // IMPORTANT: leftQ - rightQ, not rightQ - leftQ
        diff += 9 * (leftQ - rightQ) / 2;

        // diff == 0 -> Bob can make the sums equal
        return diff != 0;
    }
}