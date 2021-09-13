class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int min = Integer.MAX_VALUE;
        min = Math.min(min, map.getOrDefault('b', 0));
        min = Math.min(min, map.getOrDefault('a', 0));
        min = Math.min(min, map.getOrDefault('l', 0) / 2);
        min = Math.min(min, map.getOrDefault('o', 0) / 2);
        min = Math.min(min, map.getOrDefault('n', 0));
        return min;
    }
}
