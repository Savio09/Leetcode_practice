class Solution {
    private int diff(int left, int right, int[] piles, Integer[][] dp) {
        if (left == right)
            return piles[left];
        if (dp[left][right] != null)
            return dp[left][right];

        int take_left = piles[left] - diff(left + 1, right, piles, dp);
        int take_right = piles[right] - diff(left, right - 1, piles, dp);

        dp[left][right] = Math.max(take_left, take_right);
        return dp[left][right];

    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n];
        return diff(0, n - 1, piles, dp) >= 0;
    }
}