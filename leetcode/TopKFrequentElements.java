// https://leetcode.com/problems/top-k-frequent-elements/submissions/

class Solution {
    // use priority queue so we can get k top element
    // hashmap to map the count of each element in nums
    // time complexity: O(n log n) because using priority queue
    
    class F {
        int el;
        int cnt;
        
        public F(int el, int cnt) {
            this.el = el;
            this.cnt = cnt;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<F> pq = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            pq.add(new F(e.getKey(), e.getValue()));
        }
        
        int i = 0;
        while (k > 0) {
            F c = pq.poll();
            res[i++] = c.el;
            k--;
        }
        return res;
    }
}
