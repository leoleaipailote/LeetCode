class Solution {
    public int trailingZeroes(int n) {
        int i = 5;
        int count = 0;
        while (i <= n) {
            count += n / i;
            i *= 5;
        }
        return count;
    }
}