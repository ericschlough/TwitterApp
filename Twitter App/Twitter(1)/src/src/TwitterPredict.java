package src;

import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

import java.util.List;

import javax.swing.JFrame;

public final class TwitterPredict {
    
    public static void main(String[] args) {
    	ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(false)
              .setOAuthConsumerKey("MNHFspgwe5uYNbjqX96xriMW6")
              .setOAuthConsumerSecret("omlY3j9P5lFzt2ifEo9ceagpDFABt6gkB6DJaf11jMrByXmU40")
              .setOAuthAccessToken("737772535-gMwTkVpg4Z56aBGhHCJEqNbyMrOrolyvHpNrX5QB")
              .setOAuthAccessTokenSecret("ZSh8zRh5nEzwVV9CLHuHIr1Zp6tzsPHKSkHTRUHvD8vBl");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        int count = 0, tweetCount = 0;
        Query query = new Query("Football");
        query.setLang("en");
        QueryResult result;
        
        do {
            try {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                	tweetCount++;
                	if(tweet.getUser().getFollowersCount() > 20000 || tweet.getFavoriteCount() > 500 || tweet.getRetweetCount() > 200) {
                		count++;
                		System.out.println("\n");
                		System.out.println("New Tweet!! -------------- " + count);
                        System.out.println("User: @" + tweet.getUser().getScreenName());
                		if(tweet.getMediaEntities().length > 0) {
                			for(int i = 0; i < tweet.getMediaEntities().length; i++) {
                				String type = null;
                        		MediaEntity m = tweet.getMediaEntities()[i];
                        		if(m != null) {
                        			type = m.getType();
                                	System.out.println("Media Type: ");
                        			System.out.println(m.getType());
                        			System.out.println("Favorites: ");
                        			System.out.println(tweet.getFavoriteCount());
                        			System.out.println("User Followers: ");
                        			System.out.println(tweet.getUser().getFollowersCount());
                        		}
                        		
//                        		if(type == "video") {
//                        			JFrame mediaTest = new JFrame("Media Tester");
//                                    mediaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                                    //Player mediaPanel = Manager.createRealizedPlayer(mediaURL);
//                                    
//                                    mediaTest.add(mediaPanel);
//
//                                    mediaTest.setSize(300, 300);
//                                    mediaTest.setVisible(true);
//                        		}
                        	}
                		} else {
                			System.out.println(tweet.getText());
                			Status rt = ((Status)tweet).getRetweetedStatus();
                			if(rt != null) {
                				System.out.println("Retweeted Tweet: ");
                				System.out.println("User: @" + rt.getUser().getScreenName());
                        		if(rt.getMediaEntities().length > 0) {
                        			for(int i = 0; i < rt.getMediaEntities().length; i++) {
                                		MediaEntity m = rt.getMediaEntities()[i];
                                		if(m != null) {	
                                        	System.out.println("Media Type: ");
                                			System.out.println(m.getType());
                                			System.out.println("Favorites: ");
                                			System.out.println(rt.getFavoriteCount());
                                			System.out.println("User Followers: ");
                                			System.out.println(rt.getUser().getFollowersCount());
                                		}
                                	}
                        		} else {
                        			System.out.println(rt.getText());
                        		}
                			}
                			
                		}
                    	
                	}
                }
                query = result.nextQuery();
            } catch (TwitterException te) {
                te.printStackTrace();
                System.out.println("Failed to search tweets: " + te.getMessage());
                System.exit(-1);
            }
        } while(query != null && count < 10);
        System.out.println("Total Tweets checked: ");
    	System.out.println(tweetCount);
        System.exit(0);
    	
    	
    	
    	
    	
    	
//    	System.out.println("Starting");
//        if (args.length < 1) {
//            System.out.println("Usage: java twitter4j.examples.tweets.GetRetweets [status id]");
//            System.exit(-1);
//        }
//        System.out.println("Showing up to 100 of the first retweets of the status id - [" + args[0] + "].");
//        try {
//            Twitter twitter = new TwitterFactory().getInstance();
//            List<Status> statuses = twitter.getRetweets(Long.parseLong(args[0]));
//            for (Status status : statuses) {
//                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
//            }
//            System.out.println("done.");
//            System.exit(0);
//        } catch (TwitterException te) {
//            te.printStackTrace();
//            System.out.println("Failed to get retweets: " + te.getMessage());
//            System.exit(-1);
//        }
    }
}
