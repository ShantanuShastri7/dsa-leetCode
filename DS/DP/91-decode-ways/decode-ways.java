class Solution {
    public int numDecodings(String s) {
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);

        return helper(s, 0, mem);
    }

    private int helper(String s, int index, int[] mem){
        if (index >= s.length()) {
            return 1;
        }

        if (mem[index] != -1) return mem[index];

        if (s.charAt(index) == '0') {
            return 0;
        }

        int db = 0;
        if (index <= s.length() - 2) {
            db = Integer.valueOf(s.substring(index, index + 2));
        }

        int doubleParse = 0;
        int singleParse = 0;
        
        if (db >= 10 && db <= 26) {
            doubleParse = helper(s, index + 2, mem);
        }
        
        singleParse = helper(s, index + 1, mem);

        return mem[index] = doubleParse + singleParse;
    }
}