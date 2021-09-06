class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        TrieNode trie = buildTrie(dictionary);
        return replace(words, trie);
    }
    
    TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode(' ');
        for (String w : words) {
            TrieNode temp = root;
            for (char c : w.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }
    
    String replace(String[] words, TrieNode trie) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(getShortestReplacement(w, trie));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    String getShortestReplacement(String word, TrieNode trie) {
        TrieNode temp = trie;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return word;
            }
            
            sb.append(temp.children[c - 'a'].val);
            if (temp.children[c - 'a'].isWord) {
                return sb.toString();
            }
            temp = temp.children[c - 'a'];
        }
        return word;
    }
    
    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
        
        TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
