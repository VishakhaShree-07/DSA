class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;
        long S = (n * (n + 1)) / 2;
        long S2 = (n * (n + 1) * (2 * n + 1)) / 6;
        
        long sum = 0;
        long sum2 = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum2 += (long) nums[i] * nums[i];
        }
                long val1 = sum - S;
        long val2 = sum2 - S2;
        long val3 = val2 / val1;         
        int repeating = (int) ((val1 + val3) / 2);
        int missing = (int) (val3 - repeating);
        return new int[]{repeating, missing};
    }
}