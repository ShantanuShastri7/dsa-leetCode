class Twitter {
    // Global timestamp to order tweets chronologically
    private static int timestamp = 0;

    // Helper class to tie a tweet to its creation time
    private class Tweet {
        int id;
        int time;
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    // Map a user to the SET of people they follow (Set prevents duplicate follows)
    private Map<Integer, Set<Integer>> followees;
    // Map a user to the LIST of tweets they have posted
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // computeIfAbsent safely initializes the list if it doesn't exist yet
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-Heap: Sorts tweets from most recent (highest time) to oldest
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // A user's feed includes their own tweets, plus the people they follow
        Set<Integer> usersToPullFrom = new HashSet<>();
        usersToPullFrom.add(userId);
        
        if (followees.containsKey(userId)) {
            usersToPullFrom.addAll(followees.get(userId));
        }

        // Gather the latest tweets from all valid users
        for (int user : usersToPullFrom) {
            if (tweets.containsKey(user)) {
                List<Tweet> userTweets = tweets.get(user);
                
                // We only need to check the last 10 tweets of any given user
                int n = userTweets.size();
                for (int i = n - 1; i >= Math.max(0, n - 10); i--) {
                    pq.offer(userTweets.get(i));
                }
            }
        }

        // Pop the top 10 most recent tweets for the feed
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().id);
            count++;
        }
        
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId)) {
            // Because it's a Set of Objects, this safely removes by value, not by index
            followees.get(followerId).remove(followeeId);
        }
    }
}