class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair(c, 1));
            }else{
                if(st.peek().t==c){
                    st.push(new Pair(c, st.pop().v+1));
                }else{
                    st.push(new Pair(c, 1));
                }

                if(st.peek().v==k){
                    st.pop();
                }
            }
        }


        StringBuilder str = new StringBuilder();

        while(!st.isEmpty()){
            str.append(String.valueOf(st.peek().t).repeat(st.pop().v));
        }

        return str.reverse().toString();
    }

    class Pair<T,V>{
        T t;
        V v;
        public Pair(T t, V v){
            this.t = t;
            this.v = v;
        }
    }
}