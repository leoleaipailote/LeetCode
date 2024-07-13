class Solution {
    public int singleNumber(int[] nums) {
        int remainder = 0;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            for (int num : nums)
                remainder += (num >> i) & 1;
            if (remainder % 3 == 1)
                ans += 1 << i;
            remainder = 0;
        }
        return ans;
    }
}