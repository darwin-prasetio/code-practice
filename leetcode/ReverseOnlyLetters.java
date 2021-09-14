class Solution {
    public String reverseOnlyLetters(String s) {
        char[] res = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (!isAlphabet(s.charAt(i))) {
                res[i] = s.charAt(i);
                i++;
            } else if (!isAlphabet(s.charAt(j))) {
                res[j] = s.charAt(j);
                --j;
            } else {
                res[i] = s.charAt(j);
                res[j] = s.charAt(i);
                ++i;
                --j;
            }
        }
        return new String(res);
    }
    
    private boolean isAlphabet(char c) {
        return Character.isLetter(c);
    }
}
