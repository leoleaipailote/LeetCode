class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int max = Integer.MIN_VALUE;
        int currMin = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            currMax = Math.max(nums[i], nums[i] + currMax);
            max = Math.max(max, currMax);
            currMin = Math.min(nums[i], nums[i] + currMin);
            min = Math.min(min, currMin);
        }
        if (min == sum)
            return max;
        return Math.max(max, sum - min);

    }
}