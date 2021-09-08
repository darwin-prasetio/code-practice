class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        return shiftLetters(s, sumShifts(shifts));
    }
    
    private int[] sumShifts(int[] shifts) {
        int n = shifts.length;
        int[] sum = new int[n];
        sum[n - 1] = shifts[n - 1] % 26;
        for (int i = n - 2; i >= 0; --i) {
            sum[i] = (shifts[i] + sum[i + 1]) % 26;
        }
        return sum;
    }
    
    private String shiftLetters(String s, int[] shifts) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char c = (char) (s.charAt(i) + shifts[i]);
            if (c > 'z') {
                c = (char) (c - 26);
            }
            chars[i] = c;
        }
        return new String(chars);
    }
}
