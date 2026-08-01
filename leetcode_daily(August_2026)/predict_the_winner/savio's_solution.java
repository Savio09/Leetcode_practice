class Solution {
    private int scoreDiff(int left, int right, int[] nums, Integer[][] memo) {
        if (left == right)
            return nums[left];
        if (memo[left][right] != null)
            return memo[left][right];

        int takeLeft = nums[left] - scoreDiff(left + 1, right, nums, memo);
        int takeRight = nums[right] - scoreDiff(left, right - 1, nums, memo);

        memo[left][right] = Math.max(takeLeft, takeRight);
        return memo[left][right];
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return scoreDiff(0, n - 1, nums, memo) >= 0;
    }
}