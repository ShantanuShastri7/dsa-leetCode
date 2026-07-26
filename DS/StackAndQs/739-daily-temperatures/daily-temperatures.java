class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();

        int[] ans = new int[temperatures.length];

        for(int i=temperatures.length-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[i]>=st.peek()[0]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i]=0;
                st.push(new int[]{temperatures[i], i});
            }
            else{
                int[] hehe = st.peek();
                ans[i]=hehe[1]-i;
                st.push(new int[]{temperatures[i], i});
            }
        }

        return ans;
    }
}