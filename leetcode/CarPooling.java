class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        
        PriorityQueue<Pool> pq = new PriorityQueue<>((a, b) -> a.to - b.to);
        int currentCapacity = 0;
        for (int[] trip : trips) {
            Pool cur = new Pool(trip[0], trip[1], trip[2]);
            while (!pq.isEmpty() && pq.peek().to <= cur.from) {
                Pool off = pq.poll();
                currentCapacity -= off.pax;
            }
            
            currentCapacity += cur.pax;
            if (currentCapacity > capacity) {
                return false;
            }
            pq.add(cur);

        }
        return true;
    }
    
    class Pool {
        int pax;
        int from;
        int to;
        
        Pool(int pax, int from, int to) {
            this.pax = pax;
            this.from = from;
            this.to = to;
        }
        
        String print() {
            return "" + pax + " " + from + " " + to;
        }
    }
}
