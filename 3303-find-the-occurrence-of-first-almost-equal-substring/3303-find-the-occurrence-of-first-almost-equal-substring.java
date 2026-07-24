class Solution {
    public int minStartingIndex(String s, String pattern) {
        int m = pattern.length();

        char[] chars = (pattern + s).toCharArray();

        // Forward matching
        int[] forward = z(chars);

        // Reverse pattern and s separately
        reverse(chars, 0, m);
        reverse(chars, m, s.length());

        // Backward matching
        int[] backward = z(chars);

        for (int i = m; i <= chars.length - m; i++) {

            int leftMatch = forward[i];
            int rightMatch = backward[chars.length - i];

            if (leftMatch + rightMatch >= m - 1) {
                return i - m;
            }
        }

        return -1;
    }

    private int[] z(char[] chars) {
        int n = chars.length;
        int[] z = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {

            if (i <= r) {
                z[i] = Math.min(
                    r - i + 1,
                    z[i - l]
                );
            }

            while (i + z[i] < n &&
                   chars[z[i]] == chars[i + z[i]]) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }

    private void reverse(char[] chars, int from, int length) {
        int left = from;
        int right = from + length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }
}