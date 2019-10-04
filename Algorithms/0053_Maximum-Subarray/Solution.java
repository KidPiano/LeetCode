class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int max_ending_here = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(max_ending_here + nums[i], nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
