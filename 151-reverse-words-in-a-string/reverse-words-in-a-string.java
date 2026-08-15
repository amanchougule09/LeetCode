class Solution {
    public String reverseWords(String s) {
        String[] words = s.strip().split("\\s+");

        for(int i=0; i< words.length/2;i++){
            String temp = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = temp;
        }
        return String.join(" ", words);
    }
}