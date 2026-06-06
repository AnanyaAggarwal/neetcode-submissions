class MinStack {
    // Why Long? Code was failing while storing "integer" values cuz of integer overflow
    // when computing 2 * val during the case when the input values use
    // the extreme ends of the int range (e.g., 2147483647 and -2147483648),
    // so 2 * val exceeds the int limit, causing wrap‑around to incorrect values.
    Stack<Long> mainStack;
    long min;

    // Formula for storing new value when its the new min -
    // new encoded val = 2 * actual val - prev min

    public MinStack() {
        mainStack = new Stack<>();
        min = 0;
    }
    
    public void push(int val) {
        if (mainStack.isEmpty()) {
            mainStack.push((long) val);
            min = val;
        } else {
            long valLong = (long) val;
            // Push modified value in stack if new val is less than curr min
            if (valLong < min) {
                long newEncodedVal = (2 * valLong) - min;
                mainStack.push(newEncodedVal);
                min = valLong;
            } else {
                mainStack.push(valLong);
            }
        }
    }
    
    public void pop() {
        long top = mainStack.pop();
        // meaning min was modified, we need to get prev_min
        if (top < min) {
            // Restore previous min
            min = (2 * min) - top;
        }
    }
    
    public int top() {
        long top = mainStack.peek();
        if (top < min) {
            top = min;
        }
        return (int) top;
    }
    
    public int getMin() {
        return (int) min;
    }
}
