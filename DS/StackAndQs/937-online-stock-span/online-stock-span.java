class StockSpanner {
    Deque<Pair<Integer, Integer>> q = new ArrayDeque<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        if(!q.isEmpty()){
            int span=1;
            while(!q.isEmpty() && q.peekFirst().getKey()<=price){
                Pair<Integer, Integer> node = q.removeFirst();
                span+=node.getValue();
            }
            q.addFirst(new Pair<>(price, span));
            return span;
        } else{
            q.addFirst(new Pair<>(price, 1));
            return 1;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */