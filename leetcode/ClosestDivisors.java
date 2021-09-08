class Solution {
    public int[] closestDivisors(int x) {
        for (int i = (int) Math.sqrt(x + 2); i > 0; --i) {
            if ((x + 1) % i == 0)
                return new int[]{i, (x + 1) / i};
            if ((x + 2) % i == 0)
                return new int[]{i, (x + 2) / i};
        }
        return new int[]{};
    }
}
