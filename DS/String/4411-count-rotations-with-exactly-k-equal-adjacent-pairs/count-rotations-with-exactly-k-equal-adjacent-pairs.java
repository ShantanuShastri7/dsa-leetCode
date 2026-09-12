class Solution {
    public int countRotations(String s, int k) {
        int res=0;
        StringBuilder str = new StringBuilder();
        str.append(s);
        str.append(s);
        String newS = str.toString();
        for(int i=0; i<s.length(); i++){
            if(count(newS.substring(i, i+s.length()))==k) res++;
        }

        return res;
    }

    private int count(String s){
        int res =0;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)) res++;
        }

        return res;
    }
}