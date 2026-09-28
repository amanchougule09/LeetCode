class Solution {
    public int maxDepth(String s) {
        int max=0;
        int count=0;
        for(char i:s.toCharArray()){
            if(i == '('){
                count++;
            }
            else if(i == ')'){
                count--;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}