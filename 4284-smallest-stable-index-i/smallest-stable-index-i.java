class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        

        int currentMax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            currentMax = Math.max(currentMax, nums[i]);
            prefMax[i] = currentMax;
        }

        int currentMin = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            currentMin = Math.min(currentMin, nums[i]);
            suffMin[i] = currentMin;
        }

        for(int i=0; i<n; i++){
            if(prefMax[i] - suffMin[i] <= k){
                return i;
            }
        }
        return -1;
    }
}