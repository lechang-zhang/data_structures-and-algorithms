class Solution {
    public void nextPermutation(int[] nums) {
        //Find the first descending-breaker --> Find the first number that is bigger than the breaker --> change the elements behind the breaker to ascending order
        int length = nums.length;
        //Edge case
        if(length <= 1) {
            return;
        }
        int breaker = length - 2;
        while(nums[breaker] >= nums[breaker + 1]) {
            breaker--;
            if(breaker < 0) {
                break;
            }
        }
        //When next permutation is possible
        if(breaker >= 0) {
            //binary search to find the next larger element
            int low = breaker + 1, high = length - 1;
            while(high >= low) {
                int mid = low + (high - low) / 2;
                if(nums[mid] <= nums[breaker]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int temp;
            temp = nums[breaker];
            nums[breaker] = nums[high];
            nums[high] = temp;
            reverse(nums, breaker + 1, length - 1);
        } else { //When next permutation is impossible
            reverse(nums, 0, length - 1);
        }
    }
    public void reverse(int[] arr, int low, int high) {
        int temp;
        while(low < high) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}