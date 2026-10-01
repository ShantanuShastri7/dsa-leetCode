class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                if (stack.size() % 2 == 1) {
                    res[i] = 0;
                } else {
                    res[i] = 1;
                }
            } else {
                if (c == ')' && stack.peek() == '(') {
                    if (stack.size() % 2 == 1) {
                        res[i] = 0;
                    } else {
                        res[i] = 1;
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                    if (stack.size() % 2 == 1) {
                        res[i] = 0;
                    } else {
                        res[i] = 1;
                    }
                }
            }
        }

        return res;
    }
}