class Solution {
    public String countAndSay(int n) { 
        if(n==1) {
            return "1";
        }
        String res = "1";

        for(int i = 0; i<n-1; i++) {
            res = this.generateNextRLE(res);
        }

        return res;
    }

    private String generateNextRLE(String str) {
        String res = "";
        List<Pair<Integer, Integer>> intMap = this.generateRLEMap(str);

        for(Pair<Integer, Integer> i : intMap) {
            res = res + i.getKey().toString() + i.getValue().toString();
        }

        return res;
    }

    private List<Pair<Integer, Integer>> generateRLEMap(String str) {
        List<Pair<Integer, Integer>> listOfPairs = new ArrayList<>();

        if(str.length()==1) {
            listOfPairs.add(new Pair<Integer, Integer>(1, Character.getNumericValue(str.charAt(0))));
            return listOfPairs;
        }

        for(int i = 0; i<str.length(); i++) {
            int count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            listOfPairs.add(new Pair<Integer, Integer>(count, Character.getNumericValue(str.charAt(i))));
        }

        return listOfPairs;
    }
}