class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;

        // 1. Find the positions of the min and max elements
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        // 2. Identify which index is closer to the left (start) and right (end)
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        // 3. Calculate the 3 possible deletion strategies
        int deleteBothFromFront = right + 1;
        int deleteBothFromBack  = n - left;
        int deleteFromBothSides = (left + 1) + (n - right);

        // 4. Return the most efficient strategy
        return Math.min(deleteBothFromFront, Math.min(deleteBothFromBack, deleteFromBothSides));
    }
}
