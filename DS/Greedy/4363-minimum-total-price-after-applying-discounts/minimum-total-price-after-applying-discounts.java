class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double finalP = 0d;

        int dPointer = discounts.length-1;

        for(int i=prices.length-1; i>=0; i--){
            if(dPointer>=0){
                finalP+=(double)((double)prices[i]*(100-discounts[dPointer]))/100;
                dPointer--;
            }else{
                finalP+=prices[i];
            }
        }

        return finalP;

    }
}