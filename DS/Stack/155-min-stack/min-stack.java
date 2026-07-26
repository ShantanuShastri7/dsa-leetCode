class MinStack {
    ArrayList<Integer> st;
    ArrayList<Integer> minVals;

    public MinStack() {
        st = new ArrayList<>();
        minVals = new ArrayList<>();
    }

    public void push(int value) {
        st.add(value);
        
        // If it's the first element, it is the minimum.
        if (minVals.isEmpty()) {
            minVals.add(value);
        } else {
            // Otherwise, the current minimum is the smaller of:
            // 1. The new value
            // 2. The previous minimum (sitting at the top of minVals)
            int currentMin = minVals.get(minVals.size() - 1);
            minVals.add(Math.min(value, currentMin));
        }
    }

    public void pop() {
        // Remove the top element from both lists to travel back in time
        st.remove(st.size() - 1);
        minVals.remove(minVals.size() - 1);
    }

    public int top() {
        return st.get(st.size() - 1);
    }

    public int getMin() {
        return minVals.get(minVals.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */