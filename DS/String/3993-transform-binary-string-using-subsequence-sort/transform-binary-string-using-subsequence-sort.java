class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int sZero=0;
        int sOne=0;

        for(char c :s.toCharArray()){
            if(c=='0') sZero++;
            else sOne++;
        }

        boolean[] res = new boolean[strs.length];

        for(int i=0; i<strs.length; i++){
            res[i]=helper(s, strs[i], sZero, sOne);
        }

        return res;
        
    }

    private boolean helper(String s, String t, int sZero, int sOne){
        int tZero=0;
        int tOne=0;

        for(char c :t.toCharArray()){
            if(c=='1') tOne++;
            else if(c=='0') tZero++;
        }

        if(tZero>sZero || tOne>sOne) return false;

        int zeroToAdd=sZero-tZero;
        int oneToAdd=sOne-tOne;

        StringBuilder str = new StringBuilder();

        for(char c : t.toCharArray()){
            if(c=='?'){
                if(zeroToAdd>0){
                    str.append('0');
                    zeroToAdd--;
                } else if(oneToAdd>0){
                    str.append('1');
                    oneToAdd--;
                }
            }else{
                str.append(c);
            }
        }

        String newT = str.toString();

        int sIndex=0;
        int tIndex=0;
        for(int i=0; i<sZero; i++){
            while(s.charAt(sIndex)!='0'){
                sIndex++;
            }

            while(newT.charAt(tIndex)!='0'){
                tIndex++;
            }
            if(tIndex>sIndex) return false;

            tIndex++;
            sIndex++;
        }

        sIndex=0;
        tIndex=0;

        for(int i=0; i<sOne; i++){
            while(s.charAt(sIndex)!='1'){
                sIndex++;
            }

            while(newT.charAt(tIndex)!='1'){
                tIndex++;
            }
            if(tIndex<sIndex) return false;

            tIndex++;
            sIndex++;
        }

        return true;
    }
}