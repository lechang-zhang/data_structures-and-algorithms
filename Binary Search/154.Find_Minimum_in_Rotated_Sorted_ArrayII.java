class Solution {
    public int findMin(int[] nums) {
        //Almost as same as NO.153, but the nums[mid] = nums[high] case is tricky
        int low = 0, high = nums.length - 1;
        while(high > low) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else { //nums[mid] = nums[high]
                if(nums[high] < nums[high - 1]) {
                    break;
                }
                high--;
            }
        }
        return nums[high];
    }
}