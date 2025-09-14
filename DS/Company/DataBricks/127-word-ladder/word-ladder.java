class Pair<T,K>{
    T first;
    K order;

    Pair(T first, K order){
        this.first=first;
        this.order=order;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==endWord) return 0;
        if(wordList.size()==0) return 0;

        Set<String> wordList2 = new HashSet<>();
        for(String word : wordList) wordList2.add(word);

        Queue<Pair<String, Integer>> q = new LinkedList<>();

        q.offer(new Pair<String, Integer>(beginWord, 1));

        while(!q.isEmpty()){
            Pair<String, Integer> node = q.poll();

            String startWord = node.first;
            Integer order = node.order;
            if(startWord.equals(endWord)) return order;

            ArrayList<String> changedWords = generateOptions(startWord, wordList2);

            for(String changedWord : changedWords){
                wordList2.remove(startWord);
                q.offer(new Pair<String, Integer>(changedWord, order+1));
            }
        } 

        return 0;
    }

    private ArrayList<String> generateOptions(String word, Set<String> wordSet) {
    ArrayList<String> options = new ArrayList<>();
    char[] chars = word.toCharArray(); 

    for (int i = 0; i < chars.length; i++) {
        char original = chars[i]; 

        for (char c = 'a'; c <= 'z'; c++) {
            if (c == original) continue; 

            chars[i] = c;
            String newWord = new String(chars);

            if (wordSet.contains(newWord)) {
                options.add(newWord);
            }
        }
        chars[i] = original;
    }

    return options;
}
}