package ca.ualberta.cs.lonelytwitter;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by joshua2 on 9/29/15.
 */
public class TweetList implements MyObservable, MyObserver{ //model
    private Tweet mostRecentTweet; //model
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>(); //model

    public void add(Tweet tweet) { //controller
        mostRecentTweet = tweet; //model
        tweets.add(tweet); //controller
        tweet.addObserver(this);  //controller
        notifyAllObservers(); //controller
    }

    public Tweet getMostRecentTweet() { //model
        return mostRecentTweet;
    } //model

    public int count() { //model
        return tweets.size();
    } //model

    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>(); //controller

    public void addObserver(MyObserver observer) { //controller
        observers.add(observer);

    }

    private void notifyAllObservers() { //controller
        for(MyObserver observer: observers) {
            observer.myNotify(this);
        }
    }

    public void myNotify(MyObservable observable) { //controller
        notifyAllObservers();

    }
}
