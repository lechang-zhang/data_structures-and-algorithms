class Solution {
    public int findPeakElement(int[] nums) {
        //O(log n) tells us to use binary search
        //We assume that left[i - 1] < left[i] && right[i] > right[i + 1], if nums[mid] > nums[mid + 1], then it follows the left rule, left = mid + 1; else, it follows the right rule, right = mid. And this rule will still be true in the boundary case---nums[0 - 1] = -¡Þ < nums[0], nums[nums.length - 1] > nums[nums.length] = -¡Þ. 
        //If the array contains only one element, we just return the first index 0.
        if(nums.length == 1) {
            return 0;
        }
        //Otherwise, do the binary search
        int left = 0, right = nums.length - 1;
        while(right > left) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}