##  Find Minimum in Rotated Sorted Array 

Coming soon...

```class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            // if (nums[lo] < nums[hi])
            //     return nums[lo];            
            int mid = (lo + hi) / 2;
            if (nums[mid] >= nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        
        return nums[lo];
    }
}

// the commented out early termination is optional, and saves time in some cases 
// (in worst case it increases runtime)
```
blah

to do:
- early termination
- edge case (low + high) over int max
