class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            if (nums[mid] > nums[mid - 1])
                left = mid + 1;
            else
                right = mid;
        }
        return -1;
    }
}