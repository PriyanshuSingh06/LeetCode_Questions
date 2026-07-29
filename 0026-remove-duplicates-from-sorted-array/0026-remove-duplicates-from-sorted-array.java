import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                nums[index] = num;
                index++;
            }
        }

        return index;
    }
}