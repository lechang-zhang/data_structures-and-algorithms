class Solution {
    //Typical question of binary search
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(high >= low) {
            int mid = low + (high - low) / 2;
            if(target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}