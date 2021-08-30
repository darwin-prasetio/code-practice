class Twitter {
    class Tweet {
        int time;
        int id;
        
        Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }
    
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Tweet>> tweets;
    int feedLimit = 10;
    int t = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> l = tweets.getOrDefault(userId, new ArrayList<>());
        l.add(new Tweet(t, tweetId));
        tweets.put(userId, l);
        ++t;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> f = following.getOrDefault(userId, new HashSet<>());
        f.add(userId);
        return sortAndLimit(collectTweets(f));
    }
    
    List<Integer> sortAndLimit(List<Tweet> l) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (Tweet t : l) {
            pq.add(t);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < feedLimit && !pq.isEmpty(); ++i) {
            res.add(pq.poll().id);
        }
        return res;
    }
    
    List<Tweet> collectTweets(Set<Integer> users) {
        List<Tweet> res = new ArrayList<>();
        for (Integer uid : users) {
            res.addAll(tweets.getOrDefault(uid, new ArrayList<>()));
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> f = following.getOrDefault(followerId, new HashSet<>());
        f.add(followeeId);
        following.put(followerId, f);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> f = following.getOrDefault(followerId, new HashSet<>());
        f.remove(followeeId);
        following.put(followerId, f);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
