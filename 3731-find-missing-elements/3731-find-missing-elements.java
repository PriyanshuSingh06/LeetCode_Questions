class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean[] present = new boolean[101];

        int min = 101, max = 0;

        for (int num : nums) {
            present[num] = true;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!present[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}