class Solution {
    public int findMin(int[] nums) {
        //It's simple to do with the method1 of NO.33
        //Just use binary search to find it.
        int low = 0, high = nums.length - 1;
        while(high > low) {
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}