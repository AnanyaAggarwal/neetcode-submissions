class StockSpanner {
    Stack<Pair<Integer, Integer>> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            int topSpan = stack.pop().getValue();
            span += topSpan;
        }
        stack.push(new Pair<>(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */