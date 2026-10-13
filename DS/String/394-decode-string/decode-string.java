class Solution {
    // 1. Global pointer to track our position across ALL recursive calls
    int index = 0; 

    public String decodeString(String s) {
        return helper(s);
    }

    private String helper(String s) {
        StringBuilder str = new StringBuilder();

        // Keep reading until we hit the end of the string OR a closing bracket
        while (index < s.length() && s.charAt(index) != ']') {
            
            // Case A: We hit a number
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                
                // Parse the full number using your StringBuilder approach
                StringBuilder num = new StringBuilder();
                while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    num.append(s.charAt(index));
                    index++;
                }
                int rep = Integer.parseInt(num.toString());

                // Skip the '[' character
                index++;

                // 2. RECUSIVE CALL: Decode whatever is inside the brackets
                String deep = helper(s);

                // Skip the ']' character that ended the recursive call
                index++;

                // Append the deep string 'rep' times
                str.append(deep.repeat(rep));
            } 
            // Case B: We hit a normal letter
            else {
                str.append(s.charAt(index));
                index++;
            }
        }

        return str.toString();
    }
}