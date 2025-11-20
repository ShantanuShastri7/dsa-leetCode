class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v = val;

        if (st.isEmpty()) {
            st.push(v);
            min = v;
        } else if (v >= min) {
            st.push(v);
        } else {
            // encode
            st.push(2*v - min);
            min = v;
        }
    }
    
    public void pop() {
        long popped = st.pop();
        if (popped < min) {
            // popped was encoded → decode previous min
            min = 2*min - popped;
        }
    }
    
    public int top() {
        long top = st.peek();
        if (top < min) {
            return (int)min;   // encoded → actual is min
        }
        return (int)top;
    }
    
    public int getMin() {
        return (int)min;
    }
}