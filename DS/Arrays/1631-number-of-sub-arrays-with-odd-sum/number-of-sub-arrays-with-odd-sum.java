class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int evenSoFar=1;
        int oddSoFar=0;
        int res=0;
        int sum =0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            boolean even = sum%2==0;

            if(!even){
                res++;
                res = res%MOD;
                res+=(evenSoFar-1)%MOD;
                res = res%MOD;
                oddSoFar++;
            }else{
                res+=oddSoFar%MOD;
                res = res%MOD;
                evenSoFar++;
            }
        }

        return res%MOD;
    }
}