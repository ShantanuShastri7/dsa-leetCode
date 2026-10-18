class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > (long) num * 9) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        // 2. Greedily construct the number
        for (int i = 0; i < num; i++) {
            // The largest valid digit is either 9, or whatever is left in 'sum'
            int digit = Math.min(9, sum);
            res.append(digit);
            sum -= digit;
        }

        // 3. Since we pre-validated, we know the result is perfectly correct
        return res.toString();
    }

    private int helper(int digits, int newNum, int sumOfSquares, int sumOfDigits, int num, int sum, int[] max, String[] fin){
        if(digits==num){
            if(sumOfDigits==sum) return sumOfSquares;
            else return Integer.MIN_VALUE;
        }

        for(int i=9; i>=0; i--){
            if(digits==0 && i==0) continue;
            int next = newNum*10+i;
            int res = helper(digits+1, next, sumOfSquares+(int)Math.pow(i,2), sumOfDigits+i, num, sum, max, fin);
            if(res==-1) return -1;
            if(res>max[0]){
                fin[0] = String.valueOf(next);
                max[0]=res;
                return -1;
            } else if(res==max[0]){
                if(!fin[0].equals("") && Integer.valueOf(fin[0])<next){
                    fin[0] = String.valueOf(next);
                    max[0]=res;
                }
            }else{}
        }

        return max[0];
    }
}