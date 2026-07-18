class Solution {
    public int maxProduct(int[] nums) {
        int prefixProduct = 1;
        int suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            prefixProduct *= nums[i];
            suffixProduct *= nums[size - i - 1];
            maxProduct = Math.max(maxProduct,
            Math.max(prefixProduct, suffixProduct));

            if (prefixProduct == 0) {
                prefixProduct = 1;
            }
            if (suffixProduct == 0) {
                suffixProduct = 1;
            }
        }

        return maxProduct;
    }
}
