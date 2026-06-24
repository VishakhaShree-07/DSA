import java.util.HashMap;

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        int xr = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            xr = xr ^ nums[i];
            int x = xr ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return count;
    }
}