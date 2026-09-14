import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push the matching closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, check if stack is empty or mismatch occurs
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // If stack is empty, all brackets were validly closed
        return stack.isEmpty();
    }
}
