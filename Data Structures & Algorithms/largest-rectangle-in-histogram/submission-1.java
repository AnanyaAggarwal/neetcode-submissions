class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int currHeight = heights[stack.pop()];
                int nextSmallerElIdx = i;
                int previousSmallerElIdx = stack.isEmpty()
                ? -1 : stack.peek();
                int width = nextSmallerElIdx - previousSmallerElIdx - 1;
                maxArea = Math.max(maxArea, currHeight * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int currHeight = heights[stack.pop()];
            int nextSmallerElIdx = len;
            int previousSmallerElIdx = stack.isEmpty()
            ? -1 : stack.peek();
            int width = nextSmallerElIdx - previousSmallerElIdx - 1;
            maxArea = Math.max(maxArea, currHeight * width);
        }

        return maxArea;
    }
}
