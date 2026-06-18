class Solution {
    public long numberOfInversions(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private long mergeSortAndCount(int[] nums, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(nums, left, mid);
            count += mergeSortAndCount(nums, mid + 1, right);
            count += mergeAndCount(nums, left, mid, right);
        }
        return count;
    }

    private long mergeAndCount(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;      
        int j = mid + 1;   
        int k = 0;         
        long count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            nums[i] = temp[k];
        }

        return count;
    }
}
