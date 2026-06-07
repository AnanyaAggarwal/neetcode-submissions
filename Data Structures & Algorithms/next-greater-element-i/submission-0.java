class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> valToIdx = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            valToIdx.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < nums2.length; i++) {
            int currVal = nums2[i];
            while (!stack.isEmpty() && currVal > stack.peek()) {
                int poppedEl = stack.pop();
                int idx = valToIdx.get(poppedEl);
                res[idx] = currVal;
            }
            if (valToIdx.containsKey(currVal)) {
                stack.push(currVal);
            }
        }
        
        return res;
    }
}