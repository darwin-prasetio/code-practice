// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    // why use backtracking? because we want to know all the combinations we can get from each digit,
    // so we add a character the digit represent and then move on to the next digit, and remove the current character before moving on to the next one
    
    // why use hashmap? O(1) access time, we want to instantly know each digit map to which characters
    Map<Character, List<Character>> m = new HashMap<>();
    List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return ans;
        
        initMap();
        
        combine(digits, 0, new StringBuilder());
        return ans;
    }
    
    private void initMap() {
        m.put('2', Arrays.asList('a', 'b', 'c'));
        m.put('3', Arrays.asList('d', 'e', 'f'));
        m.put('4', Arrays.asList('g', 'h', 'i'));
        m.put('5', Arrays.asList('j', 'k', 'l'));
        m.put('6', Arrays.asList('m', 'n', 'o'));
        m.put('7', Arrays.asList('p', 'q', 'r', 's'));
        m.put('8', Arrays.asList('t', 'u', 'v'));
        m.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }
    
    private void combine(String digits, int cur, StringBuilder sb) {
        if (cur >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        List<Character> l = m.get(digits.charAt(cur));
        for (int i = 0; i < l.size(); i++) {
            sb.append(l.get(i));
            combine(digits, cur + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
