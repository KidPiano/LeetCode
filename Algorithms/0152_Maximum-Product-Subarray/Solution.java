class Solution {
    public int maxProduct(int[] nums) {
        int max_ending_here = nums[0];
        int min_ending_here = nums[0];
        int max_so_far = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int option1 = max_ending_here * nums[i];
            int option2 = min_ending_here * nums[i];
            
            max_ending_here = Math.max(Math.max(option1, option2), nums[i]);
            min_ending_here = Math.min(Math.min(option1, option2), nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        
        return max_so_far;
    }
}
