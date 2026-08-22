class Solution {
    public boolean checkDivisibility(int n) {

        if (n <= 0) return false; 

        int temp = n;
        int sum=0;
        int product=1;

        while(temp > 0){
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp = temp / 10;
        }

        int total= sum + product;

        // Prevent division by zero just in case, though n is a positive integer
        if (total == 0) return false; 
        
        // Check if n is divisible BY the total (sum + product)
        return n % total == 0; 
    }
}