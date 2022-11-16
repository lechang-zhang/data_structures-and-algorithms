var isIdealPermutation = function(nums) {
    // Limit all the global inversions to local inversions
    // Max(nums[0~i]) < nums[i+2]
    let maxNum = 0;
    for (let i = 0; i < nums.length - 2; i++) {
        maxNum = Math.max(maxNum, nums[i]);
        if (maxNum > nums[i + 2]) return false;
    }
    return true;
};