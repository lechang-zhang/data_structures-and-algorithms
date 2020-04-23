class Solution {
    public int mySqrt(int x) {
        //Solve this problem by binary search
        if(x == 0) {
            return 0;
        }
        int left = 1, right = x, res = 0;
        while(right >= left) {
            int mid = left + (right - left) / 2;
            if(mid < x / mid) { // mid * mid <= x, but mid * mid may be bigger than INTEGER_MAX£¬ so we write in this way. And x / mid will also solve the decimal digits.
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}