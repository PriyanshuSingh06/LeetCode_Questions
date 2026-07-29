class Solution {
    public int removeDuplicates(int[] nums) {
        Map <Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int num : nums){
            int count = map.getOrDefault(num, 0);

            if (count < 2) {
                nums[index] = num;
                index++;
                map.put(num, count + 1);
            }

        }
        return index;
    }
}