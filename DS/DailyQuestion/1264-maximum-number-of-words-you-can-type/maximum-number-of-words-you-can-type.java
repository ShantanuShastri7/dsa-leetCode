class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        char[] broken = brokenLetters.toCharArray();
        Set<Character> brokenSet = new HashSet<>();

        for(char c : broken){
            brokenSet.add(c);
        }
        int count=0;
        for(String word : words){
            char[] w = word.toCharArray();
            for(char a : w){
                if(brokenSet.contains(a)) {
                    count++;
                    break;
                }
            }
        }

        return words.length-count;
    }
}