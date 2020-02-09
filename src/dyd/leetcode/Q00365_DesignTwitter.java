package dyd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 355. Design Twitter -- Medium
 *
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see
 * the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
 * be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least
 * recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 *
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Q00365_DesignTwitter {
    private static final int MAX_TWEETS_NUM = 10;

    private Map<Integer, TreeMap<Long, Integer>> allTweets;
    private Map<Integer, Set<Integer>> followees;

    /** Initialize your data structure here. */
    public Q00365_DesignTwitter() {
        allTweets = new HashMap<>();
        followees = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        allTweets.putIfAbsent(userId, new TreeMap<>(Collections.reverseOrder()));
        TreeMap<Long, Integer> tweets = allTweets.get(userId);
        tweets.put(System.nanoTime(), tweetId);
        if (tweets.size() > MAX_TWEETS_NUM) {
            tweets.remove(tweets.lastKey());
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        TreeMap<Long, Integer> tweets = new TreeMap<>(Collections.reverseOrder());
        if (allTweets.containsKey(userId)) {
            tweets.putAll(allTweets.get(userId));
        }

        for (int followee : followees.getOrDefault(userId, new HashSet<>())) {
            if (allTweets.containsKey(followee)) {
                for (Map.Entry<Long, Integer> entry : allTweets.get(followee).entrySet()) {
                    tweets.put(entry.getKey(), entry.getValue());
                    if (tweets.size() > MAX_TWEETS_NUM) {
                        tweets.remove(tweets.lastKey());
                    }
                }
            }
        }

        return tweets.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Q00365_DesignTwitter q = new Q00365_DesignTwitter();
        q.postTweet(1, 5);
        q.postTweet(1, 3);
        System.out.println(q.getNewsFeed(1));
    }
}
