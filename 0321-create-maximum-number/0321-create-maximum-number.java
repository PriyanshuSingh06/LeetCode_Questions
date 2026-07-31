class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int m = nums1.length;
        int n = nums2.length;

        int[] answer = new int[k];

        int start = Math.max(0, k - n);
        int end = Math.min(k, m);

        for (int i = start; i <= end; i++) {

            int[] first = maxSubsequence(nums1, i);
            int[] second = maxSubsequence(nums2, k - i);

            int[] candidate = merge(first, second);

            if (greater(candidate, 0, answer, 0)) {
                answer = candidate;
            }
        }

        return answer;
    }

    private int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        if (k == 0) {
            return new int[0];
        }

        int[] stack = new int[k];

        int top = -1;
        int drop = n - k;

        for (int num : nums) {

            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }

            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    private int[] merge(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < a.length || j < b.length) {

            if (greater(a, i, b, j)) {
                result[index++] = a[i++];
            } else {
                result[index++] = b[j++];
            }
        }

        return result;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        if (j == b.length) {
            return true;
        }

        if (i == a.length) {
            return false;
        }

        return a[i] > b[j];
    }
}