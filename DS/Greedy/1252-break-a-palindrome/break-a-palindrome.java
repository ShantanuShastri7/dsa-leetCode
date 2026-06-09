class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        
        if(n==1) return "";

        boolean change=false;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n/2; i++){
            if(palindrome.charAt(i)>'a' && !change){
                sb.append('a');
                change=true;
            } else{
                sb.append(palindrome.charAt(i));
            }
        }

        for(int i=n/2; i<n-1; i++){
            sb.append(palindrome.charAt(i));
        }

        if(!change){
            int last = palindrome.charAt(n-1);
            last++; 
            sb.append((char) last);
        } else {
            sb.append(palindrome.charAt(n-1));
        }

        return sb.toString();
    }
}