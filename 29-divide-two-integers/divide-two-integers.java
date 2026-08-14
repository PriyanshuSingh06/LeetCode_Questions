 class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE &&
            divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long result = 0;

        while (a >= b) {

            long value = b;
            long multiple = 1;

            // Double the divisor using addition
            while (a >= (value << 1)) {
                value <<= 1;
                multiple <<= 1;
            }

            a -= value;
            result += multiple;
        }

        if (negative) {
            result = -result;
        }

        return (int) result;
    }
}