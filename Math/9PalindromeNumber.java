class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        double n = 1;
        int left = 0;
        int right = 0;
        while (n <= x) {
            n *= 10;
            right++;
        }
        int copLeft = x;
        int copRight = x;
        while (left < right) {
            int remLeft = copLeft / (int) Math.pow(10, right - 1);
            int remRight = copRight % 10;
            if (remLeft != remRight)
                return false;
            copLeft %= (int) Math.pow(10, right - 1);
            copRight /= 10;
            left++;
            right--;
        }
        return true;
    }
}