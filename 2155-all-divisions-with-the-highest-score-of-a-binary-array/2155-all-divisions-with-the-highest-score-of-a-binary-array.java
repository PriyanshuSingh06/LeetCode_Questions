class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int rightOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                rightOnes++;
            }
        }

        int leftZeros = 0;
        int maxScore = rightOnes;

        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                leftZeros++;
            } else {
                rightOnes--;
            }

            int score = leftZeros + rightOnes;

            if (score > maxScore) {
                maxScore = score;
                ans.clear();
                ans.add(i + 1);
            } else if (score == maxScore) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}