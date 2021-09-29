class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bVal = new int[n];
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                bVal[i] |= 1 << (c - 'a');
            }
        }
        
        int max = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((bVal[i] & bVal[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}
