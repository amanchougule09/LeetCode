class Solution {
    public int longestSubsequence(int[] nums) {
        int ans=0;
        boolean hasNonZero=false;
        for(int i: nums){

            ans ^= i;

            if (i != 0) {
                hasNonZero = true;
            }
        }

        if(!hasNonZero){
            return 0;
        }
        if(ans !=0){
            return nums.length;
        }
        return nums.length-1;
    }
}