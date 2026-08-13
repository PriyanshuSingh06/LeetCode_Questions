 import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(
            int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0,
                  new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Choose
            current.add(candidates[i]);

            // We use i, NOT i + 1
            // because the same number can be reused
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}