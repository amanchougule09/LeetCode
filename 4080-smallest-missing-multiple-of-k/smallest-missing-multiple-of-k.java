class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int num=k;
        while(set.contains(num)){
            num += k;
        }
        return num;
    }
}