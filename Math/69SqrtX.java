class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long res = mid * mid;
            if (res == x)
                return (int) mid;
            else if (res < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left * left < x ? (int) left : (int) left - 1;
    }
}