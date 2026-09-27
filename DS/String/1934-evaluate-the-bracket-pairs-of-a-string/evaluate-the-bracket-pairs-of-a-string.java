class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for(List<String> lis : knowledge){
            map.put(lis.get(0), lis.get(1));
        }

        StringBuilder str = new StringBuilder();
        int lastI=-1;
        boolean insideBracket=false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                insideBracket=true;
                lastI = i+1;
            }else if(s.charAt(i)==')'){
                StringBuilder temp = new StringBuilder(s.substring(lastI, i));
                String t = temp.toString();
                str.append(map.containsKey(t)?map.get(temp.toString()):'?');
                insideBracket=false;
            } else if(!insideBracket){
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}