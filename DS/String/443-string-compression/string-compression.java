class Solution {
    public int compress(char[] chars) {
        int start=0;
        int end=0;
        int res=0;
        int charIndex=0;

        while(end<chars.length){
            int rep=0;
            while(end<chars.length && chars[start]==chars[end]){
                rep++;
                end++;
            }

            chars[charIndex] = chars[start];
            charIndex++;
            if(rep>1){
                String rep2 = String.valueOf(rep);
                for(char c : rep2.toCharArray()){
                    chars[charIndex] = c;
                    charIndex++;
                }
            }
            start=end;
        }

        return charIndex;
    }
}