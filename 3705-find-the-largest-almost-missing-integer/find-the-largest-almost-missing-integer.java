class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Case 1: k == 1
        if (k == 1) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int ans = -1;

            for (int num : map.keySet()) {
                if (map.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // Case 2: k == n
        if (k == n) {
            int ans = nums[0];

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        // Case 3: 1 < k < n
        HashMap<Integer, Integer> windowCount = new HashMap<>();

        // Generate every window
        for (int i = 0; i <= n - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            // Traverse current window
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Each number gets counted once for this window
            for (int num : set) {
                windowCount.put(
                    num,
                    windowCount.getOrDefault(num, 0) + 1
                );
            }
        }

        // Find largest number appearing in exactly one window
        int ans = -1;

        for (int num : windowCount.keySet()) {
            if (windowCount.get(num) == 1) {
                ans = Math.max(ans, num);
            }
        }

        return ans;
    }
}