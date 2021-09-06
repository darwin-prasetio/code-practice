class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        char x = 'a', y = 'b';
        int i = a, j = b;
        if (b > a) {
            x = 'b';
            y = 'a';
            i = b;
            j = a;
        }
        
        while (i-- > 0) {
            sb.append(x);
            if (i > j) {
                --i;
                sb.append(x);
            }
            if (j-- > 0) {
                sb.append(y);
            }
        }
        
        return sb.toString();
    }
}
