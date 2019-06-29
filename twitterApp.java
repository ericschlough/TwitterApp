package twitter4j;

import java.util.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class twitterApp {

	private final String USER_AGENT = "OAuth gem v0.4.4";

	public static void main(String[] args) throws Exception {

		Twitter twitter = new TwitterFactory().getInstance();

		twitter.setOAuthConsumer("MNHFspgwe5uYNbjqX96xriMW6", "omlY3j9P5lFzt2ifEo9ceagpDFABt6gkB6DJaf11jMrByXmU40");
		twitter.setOAuthAccessToken("737772535-gMwTkVpg4Z56aBGhHCJEqNbyMrOrolyvHpNrX5QB", "ZSh8zRh5nEzwVV9CLHuHIr1Zp6tzsPHKSkHTRUHvD8vBl");


		twitterApp http = new twitterApp();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		// System.out.println("\nTesting 2 - Send Http POST request");
		// http.sendPost();

	}

// HTTP GET request
	private void sendGet() throws Exception {

		try {
	      // Getting Twitter Timeline using Twitter4j API
		    ResponseList statusReponseList = twitter.getUserTimeline(new Paging(1, 5));
		    for (Status status : statusReponseList) {
		        System.out.println(status.getText());
	    	} 
	    } catch(Exception e) {}

		// String url = "http://www.google.com/search?q=mkyong";
		
		// URL obj = new URL(url);
		// HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// // optional default is GET
		// con.setRequestMethod("GET");

		// //add request header
		// con.setRequestProperty("User-Agent", USER_AGENT);

		// int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : " + responseCode);

		// BufferedReader in = new BufferedReader(
		//         new InputStreamReader(con.getInputStream()));
		// String inputLine;
		// StringBuffer response = new StringBuffer();

		// while ((inputLine = in.readLine()) != null) {
		// 	response.append(inputLine);
		// }
		// in.close();

		// //print result
		// System.out.println(response.toString());

	}

}

