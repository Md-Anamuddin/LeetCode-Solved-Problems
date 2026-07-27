class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
        while (!st.isEmpty() && st.peek() <= nums[i % nums.length]) {
            st.pop();
        }

        if (i < nums.length) {
            nge[i] = st.isEmpty() ? -1 : st.peek();
        }

        st.push(nums[i % nums.length]);
        }
        return nge;
    }
}