class Solution {
    public String reorganizeString(String s) {
        int[] hash = buildHash(s);
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] > max) {
                letter = i;
                max = hash[i];
            }
        }
        
        if (max > (s.length() + 1) / 2) return "";
        
        char[] res = new char[s.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            hash[letter]--;
            idx += 2;
        }
        for (int i = 0; i < hash.length; ++i) {
            while (hash[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                hash[i]--;
                idx += 2;
            }
        }
        return String.valueOf(res);
    }
    
    int[] buildHash(String s) {
        int[] ans = new int[26];
        for (char c : s.toCharArray()) {
            ans[c - 'a']++;
        }
        return ans;
    }
}
