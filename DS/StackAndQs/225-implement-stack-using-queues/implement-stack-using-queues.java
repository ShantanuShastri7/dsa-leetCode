class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        int s = q.size();

        for(int i=0; i<s-1; i++){
            q.offer(q.poll());
        }

        return q.poll();
    }
    
    public int top() {
        int s = q.size();

        for(int i=0; i<s-1; i++){
            q.offer(q.poll());
        }
        int x = q.poll();
        q.offer(x);
        return x;
    }
    
    public boolean empty() {
        int s = q.size();

        return s==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */