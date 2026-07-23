import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        long t = target;

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Minimum possible sum with this i
            long min1 = (long) nums[i]
                      + nums[i + 1]
                      + nums[i + 2]
                      + nums[i + 3];

            if (min1 > t) {
                break;
            }

            // Maximum possible sum with this i
            long max1 = (long) nums[i]
                      + nums[n - 1]
                      + nums[n - 2]
                      + nums[n - 3];

            if (max1 < t) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Minimum possible sum with i and j
                long min2 = (long) nums[i]
                          + nums[j]
                          + nums[j + 1]
                          + nums[j + 2];

                if (min2 > t) {
                    break;
                }

                // Maximum possible sum with i and j
                long max2 = (long) nums[i]
                          + nums[j]
                          + nums[n - 1]
                          + nums[n - 2];

                if (max2 < t) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    if (sum < t) {
                        left++;
                    } 
                    else if (sum > t) {
                        right--;
                    } 
                    else {
                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        int leftValue = nums[left];
                        int rightValue = nums[right];

                        // Skip duplicates directly
                        while (left < right &&
                               nums[left] == leftValue) {
                            left++;
                        }

                        while (left < right &&
                               nums[right] == rightValue) {
                            right--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}