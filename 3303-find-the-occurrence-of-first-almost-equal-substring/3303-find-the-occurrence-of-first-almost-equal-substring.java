class Solution {

    public int minStartingIndex(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();

        // Prefix matches
        String combined1 = pattern + "#" + s;
        int[] z1 = zFunction(combined1);

        // Suffix matches using reversed strings
        String rs = new StringBuilder(s).reverse().toString();
        String rp = new StringBuilder(pattern).reverse().toString();

        String combined2 = rp + "#" + rs;
        int[] z2 = zFunction(combined2);

        for (int i = 0; i <= n - m; i++) {

            // Number of matching chars from the left
            int left = Math.min(
                z1[m + 1 + i],
                m
            );

            // Exact match
            if (left == m) {
                return i;
            }

            // Starting index of reversed substring
            int revStart = n - (i + m);

            // Number of matching chars from the right
            int right = Math.min(
                z2[m + 1 + revStart],
                m
            );

            // At most one mismatch
            if (left + right >= m - 1) {
                return i;
            }
        }

        return -1;
    }

    private int[] zFunction(String str) {
        int n = str.length();
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
                   str.charAt(z[i]) == str.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}