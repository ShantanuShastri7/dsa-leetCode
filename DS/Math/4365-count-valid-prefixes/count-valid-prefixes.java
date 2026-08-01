class Solution {
    public int countValidPrefixes(String s) {
        int res=0;
        int ones=0;
        int zeros=0;

        for(int i=0; i<s.length(); i++){

            //even case
            if(i%2==1){
                int x = s.charAt(i)-'0';
                if(x==0) zeros++;
                else ones++;

                if(ones==zeros) res++;
            }else{
                int x = s.charAt(i)-'0';
                if(x==0) zeros++;
                else ones++;

                if(ones+1==zeros || zeros+1==ones) res++;
            }
        }

        return res;
    }
}