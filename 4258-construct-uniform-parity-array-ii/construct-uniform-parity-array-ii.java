class Solution {
    public boolean uniformArray(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;

        //find minimum odd number
        for(int i : nums1){
            if(i % 2 == 1){
                minOdd = Math.min(i,minOdd);
            }
        }

        //Check if even number is smaller than minimum odd number.
        for(int i : nums1){
            if(i % 2 == 0 && minOdd != Integer.MAX_VALUE){
                if( i < minOdd){
                    return false;
                }
            }
        }
        return true;
    }
}