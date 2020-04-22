class Solution {
    public boolean search(int[] nums, int target) {
        //Use method2 of NO.31: There must be 2 sorted arrays in the rotated array, search target in the left sorted array or in the right sorted array
        int start = 0, end = nums.length - 1;
        while(end >= start) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                return true;
            }
            //PAY ATTENTION PLEASE! Because of the duplication of elements, we will have the case that nums[start] = nums[mid] = nums[end], in this case we cannot get a sorted array which we want.
            if(nums[start] < nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else { 
                    start = mid + 1; //target won't equal to nums[mid] here
                }
            } else if (nums[start] > nums[mid]) {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else { 
                    end = mid - 1 ; //target won't equal to nums[mid] here
                }
            } else {
                start++;
            }
        }
        return false;
    }
}