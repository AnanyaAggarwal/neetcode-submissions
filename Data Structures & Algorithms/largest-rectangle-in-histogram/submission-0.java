class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> idxStack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!idxStack.isEmpty() && heights[idxStack.peek()] > heights[i]) {
                int currHeight = heights[idxStack.pop()];
                int nextSmallerElIdx = i;
                int prevSmallerElIdx = idxStack.isEmpty()
                ? -1 : idxStack.peek();
                int width = nextSmallerElIdx - prevSmallerElIdx - 1;
                maxArea = Math.max(maxArea, currHeight * width);
            }
            idxStack.push(i);
        }

        while (!idxStack.isEmpty()) {
            int currHeight = heights[idxStack.pop()];
            int nextSmallerElIdx = n;
            int prevSmallerElIdx = idxStack.isEmpty()
            ? -1 : idxStack.peek();
            int width = nextSmallerElIdx - prevSmallerElIdx - 1;
            maxArea = Math.max(maxArea, currHeight * width);
        }

        return maxArea;
    }
}
