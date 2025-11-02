class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> total = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            total.add(i);
        }
        StringBuilder newSt = new StringBuilder();
        return helper(newSt, k, total);
    }

    private String helper(StringBuilder st, int k, ArrayList<Integer> total) {
        if (k == 0) {
            for (int i = total.size()-1; i>=0; i--) {
                st.append(total.get(i));
            }
            return st.toString();
        }
        int size = total.size();
        size--;

        int boxToCheck = k / factorialUsingForLoop(size);
        //System.out.print(" int K:" + k + " boxToCheck: "+boxToCheck+" totalSize:"+total.size());

        int rem = k % factorialUsingForLoop(size);
        Integer startsWith;

        if (rem == 0) {startsWith = total.get(boxToCheck - 1);}
        else {startsWith = total.get(boxToCheck);}

        //Integer startsWith = total.get(boxToCheck);


        st.append(startsWith);
        total.remove(startsWith);
        k -= factorialUsingForLoop(size) *boxToCheck;

        return helper(st, k, total);
    }

    private int factorialUsingForLoop(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}