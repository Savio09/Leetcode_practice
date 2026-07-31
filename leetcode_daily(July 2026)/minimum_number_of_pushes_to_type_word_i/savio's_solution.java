public class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int total = 0;
        for (int i = 0; i < len; i++)
            total += (i / 8) + 1;
        return total;
    }
}
