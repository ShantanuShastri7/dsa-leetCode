class Solution {
    public boolean checkDivisibility(int n) {
        String s = String.valueOf(n);

        int sum=0;
        int pro=1;

        int x=n;
        while(x!=0){
            sum+=x%10;
            pro*=x%10;

            x=x/10;
        }
        
        return n%(sum+pro)==0;
    }
}