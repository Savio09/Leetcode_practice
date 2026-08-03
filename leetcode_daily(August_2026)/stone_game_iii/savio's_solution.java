class Solution {
    public int choice(int i, int[] stoneValue, int[] dp) {
        if (i == stoneValue.length)
            return 0;
        int best = Integer.MIN_VALUE;
        if (dp[i] != -1)
            return dp[i];
        int take = 0;
        for (int j = 0; j < 3 && i + j < stoneValue.length; j++) {
            take += stoneValue[i + j];
            best = Math.max(best, take - choice(i + j + 1, stoneValue, dp));
        }
        dp[i] = best;
        return dp[i];
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int score_diff = choice(0, stoneValue, dp);
        if (score_diff > 0)
            return new String("Alice");
        if (score_diff < 0)
            return new String("Bob");
        return new String("Tie");
    }
}