class Solution {
    public int maximumLengthSubstring(String s) {
        int ans=0;

        for(int i=0; i<s.length(); i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j=i; j<s.length(); j++){
                map.merge(s.charAt(j), 1, Integer::sum); 
                if(map.get(s.charAt(j))<=2){
                    ans=Math.max(ans, j-i+1);
                }else{
                    break;
                }
            }
        }

        return ans;
        
    }
}