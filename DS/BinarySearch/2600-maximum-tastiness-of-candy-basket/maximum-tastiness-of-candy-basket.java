class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        
        int min = 0;
        int max = price[price.length-1] - price[0];
        int answer =0;

        while(min<=max){
            int mid = (min+max)/2;
            if(helper(price, k, mid)){
                answer=Math.max(answer, mid);
                min=mid+1;
            } else{
                max=mid-1;
            }
        }

        return answer;
    }

    private boolean helper(int[] prices, int k, int gap){
        int left=0;
        int right=1;
        int canPick=1;

        while(right<prices.length){
            if(prices[right]-prices[left]>=gap){
                canPick++;
                left=right;
                right++;
            }else{
                right++;
            }
        }

        return canPick>=k;
    }
}