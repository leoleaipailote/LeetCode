class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid] > nums[mid - 1])) {
                ans[0] = mid;
                break;
            }
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                ans[1] = mid;
                break;
            }
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }

        return ans;
    }
}