class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Count the frequency of each digit in the input array
        int[] digitCounts = new int[10];
        for (int digit : digits) {
            digitCounts[digit]++;
        }
        
        int validCount = 0;
        
        // Step 2: Iterate through all possible 3-digit even numbers
        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;         // Hundreds place
            int d2 = (num / 10) % 10;   // Tens place
            int d3 = num % 10;          // Units place
            
            // Step 3: Temporarily use the digits
            digitCounts[d1]--;
            digitCounts[d2]--;
            digitCounts[d3]--;
            
            // If we have enough of each digit, the number is valid
            if (digitCounts[d1] >= 0 && digitCounts[d2] >= 0 && digitCounts[d3] >= 0) {
                validCount++;
            }
            
            // Step 4: Restore the digit counts for the next iteration
            digitCounts[d1]++;
            digitCounts[d2]++;
            digitCounts[d3]++;
        }
        
        return validCount;
    }
}
