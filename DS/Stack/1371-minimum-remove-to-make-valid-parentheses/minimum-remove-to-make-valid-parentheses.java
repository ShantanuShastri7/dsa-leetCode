class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder();

        Stack<Pair<Character, Integer>> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                Pair<Character, Integer> p = new Pair(s.charAt(i), str.length());
                str.append(s.charAt(i));
                st.push(p);
            }else if(s.charAt(i)==')'){
                if(st.size()>0){
                    str.append(s.charAt(i));
                    st.pop();
                }else{
                    continue;
                }
            }else{
                str.append(s.charAt(i));
            }
        }

        while(st.size()>0){
            Pair<Character, Integer> p = st.pop();
            str.deleteCharAt(p.v);
        }

        return str.toString();
    }

    class Pair<T,V>{
        public T t;
        public V v;
        public Pair(T t, V v){
            this.t = t;
            this.v = v;
        }
    }
}