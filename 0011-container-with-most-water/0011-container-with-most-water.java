class Solution {

    public int maxArea(int[] height) {
        return solve(height, 0, height.length - 1);
    }

    private int solve(int[] height, int left, int right) {
        // Base case
        if (left >= right) {
            return 0;
        }

        int width = right - left;
        int current = Math.min(height[left], height[right]) * width;

        if (height[left] < height[right]) {
            return Math.max(current, solve(height, left + 1, right));
        }

        return Math.max(current, solve(height, left, right - 1));
    }
}