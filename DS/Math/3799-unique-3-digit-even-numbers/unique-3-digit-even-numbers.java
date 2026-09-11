class Solution {
    public int totalNumbers(int[] digits) {
        int[] digitCounts = new int[10];
        for (int d : digits) {
            digitCounts[d]++;
        }
        
        int totalUniqueEvenNumbers = 0;
        
        // Step 2: Iterate through all possible 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int hundreds = num / 100;
            int tens = (num / 10) % 10;
            int units = num % 10;
            
            // Count required digits for the current number
            int[] requiredCounts = new int[10];
            requiredCounts[hundreds]++;
            requiredCounts[tens]++;
            requiredCounts[units]++;
            
            // Step 3: Check if we have enough of each digit available
            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (requiredCounts[i] > digitCounts[i]) {
                    canForm = false;
                    break;
                }
            }
            
            if (canForm) {
                totalUniqueEvenNumbers++;
            }
        }
        
        return totalUniqueEvenNumbers;
    }
}