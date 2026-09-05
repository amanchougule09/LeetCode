class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefMax=new int[n];
        int[] suffMin=new int[n];

        int currMax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            currMax = Math.max(currMax, nums[i]);
            prefMax[i] = currMax; 
        }

        int currMin = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            currMin = Math.min(currMin, nums[i]);
            suffMin[i] = currMin; 
        }

        for(int i=0; i<n; i++){
            if(prefMax[i] - suffMin[i] <= k){
                return i;
            }
        }
        return -1;
    }
}