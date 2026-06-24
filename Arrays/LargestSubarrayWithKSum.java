import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long currentSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum == k) {
                maxLen = i + 1;
            }

            long remaining = currentSum - k;
            if (map.containsKey(remaining)) {
                int len = i - map.get(remaining);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }

        return maxLen;
    }
}