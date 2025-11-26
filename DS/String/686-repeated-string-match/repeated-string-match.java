class Solution {
    public int repeatedStringMatch(String a, String b) {

        int n = a.length();
        boolean found = false;
        int result = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {

            int i = start;  
            int j = 0;          
            int repeats = 1;    

            while (j < b.length()) {

                if (a.charAt(i) != b.charAt(j)) {
                    break; 
                }

                j++;
                i++;

                if (i == n) {
                    i = 0;
                    if (j < b.length()) {
                        repeats++;
                    }

                    if (repeats > (b.length() / n) + 2) break;
                }
            }

            if (j == b.length()) {  
                found = true;
                result = Math.min(result, repeats);
            }
        }

        return found ? result : -1;
    }
}
