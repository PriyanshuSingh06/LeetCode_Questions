class Solution {
    public int minStartingIndex(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();

        // Match pattern with s from the left
        int[] prefix = zFunction(pattern + "#" + s);

        // Match pattern with s from the right
        String revS = new StringBuilder(s).reverse().toString();
        String revP = new StringBuilder(pattern).reverse().toString();

        int[] suffix = zFunction(revP + "#" + revS);

        for (int i = 0; i <= n - m; i++) {

            int leftMatch = Math.min(
                prefix[m + 1 + i], m
            );

            // Exact match
            if (leftMatch == m) {
                return i;
            }

            // Position of this substring in reversed s
            int revStart = n - i - m;

            int rightMatch = Math.min(
                suffix[m + 1 + revStart], m
            );

            // All chars except at most one must match
            if (leftMatch + rightMatch >= m - 1) {
                return i;
            }
        }

        return -1;
    }

    private int[] zFunction(String str) {
        int n = str.length();
        int[] z = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {

            if (i <= right) {
                z[i] = Math.min(
                    right - i + 1,
                    z[i - left]
                );
            }

            while (i + z[i] < n &&
                   str.charAt(z[i]) == str.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        return z;
    }
}