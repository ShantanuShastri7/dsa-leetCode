class Solution {
    public long countCommas(long n) {
        //1,409,752,114
        //1,000-999,999 -> 1
        //1,000,000-999,999,999 -> 2
        //1,000,000,000-999,999,999,999 -> 3
        //1,000,000,000,000-999,999,999,999,999 -> 4
        //1,000,000,000,000,000 -> 5
        long base4_6 = 999999l-1000l+1l;
        long base7_9 = 999999999l-1000000l+1l;
        long base10_12 = 999999999999l-1000000000l+1l;
        long base13_15 = 999999999999999l-1000000000000l+1l;

        String s = String.valueOf(n);
        int len = s.length();
        if(len==16){
            return base4_6+base7_9*2l+base10_12*3l+base13_15*4l+5;
        }

        if(len>=13){
            long count = n-1000000000000l+1l;
            count*=4l;
            return base4_6+base7_9*2l+base10_12*3l+count;
        }

        if(len>=10){
            long count = n-1000000000l+1l;
            count*=3l;
            return base4_6+base7_9*2l+count;
        }

        if(len>=7){
            long count = n-1000000l+1l;
            count*=2l;
            return base4_6+count;
        }

        if(len>=4){
            long count = n-1000l+1l;
            return count;
        }

        return 0l;
    }
}