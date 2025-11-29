class Trie {
    Trie[] tries = new Trie[26];
    boolean flag = false;

    public Trie() {
        
    }
    
    public void insert(String word) {
        if(word.length()==0){
            this.flag=true;
            return;
        }

        char ch = word.charAt(0);

        if(tries[ch-'a']== null){
            tries[ch-'a']=new Trie();
        }

        tries[ch-'a'].insert(word.substring(1, word.length()));
        return;
    }
    
    public boolean search(String word) {
        if(word.length()==0 ) {
            if(this.flag) return true;
            return false;
        }

        char ch = word.charAt(0);
        if(this.tries[ch -'a']==null) return false;

        return this.tries[ch -'a'].search(word.substring(1, word.length()));
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length()==0) return true;

        char ch = prefix.charAt(0);
        if(this.tries[ch -'a']==null) return false;

        return this.tries[ch -'a'].startsWith(prefix.substring(1, prefix.length()));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */