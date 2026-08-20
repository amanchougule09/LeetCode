class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()) return false;

        int[] storage = new int[26];
 
        for(char i : magazine.toCharArray()){
            storage[i-'a']++;
        }

        for(char i : ransomNote.toCharArray()){

            if(storage[i-'a'] == 0) return false;

            storage[i-'a']--;

        }
        return true;
    }
}