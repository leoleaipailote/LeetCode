class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        if (left == right)
            return left;
        while (true) {
            int cLeft = 0;
            int cRight = 0;
            int leftCopy = left;
            int rightCopy = right;
            while (leftCopy > 0) {
                leftCopy = leftCopy >> 1;
                cLeft++;
            }
            while (rightCopy > 0) {
                rightCopy = rightCopy >> 1;
                cRight++;
            }
            if (cLeft != cRight)
                break;
            int res = (int) Math.pow(2, cLeft - 1);
            ans += res;
            left -= res;
            right -= res;
        }
        return ans;
    }
}