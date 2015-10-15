package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable, MyObservable, Serializable {
    private String text; //model
    protected Date date; //model

    public Tweet(String tweet, Date date) throws TweetTooLongException { //model
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException { //model
        this.setText(tweet);
        this.date = new Date();
    }

    public String getText() { //model
        return text;
    }

    public void setText(String text) throws TweetTooLongException { //model
        if (text.length() <= 140) {
            this.text = text; //model
            notifyAllObservers(); //controller
        } else {
            throw new TweetTooLongException();
        }

    }
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>(); //controller
    public void addObserver(MyObserver observer) { //controller
        observers.add(observer);
    }
    private void notifyAllObservers() { //controller
        for(MyObserver observer: observers) {
            observer.myNotify(this);
        }
    }
    public Date getDate() {
        return date;
    } //model

    public void setDate(Date date) {
        this.date = date;
    } //model

    public abstract Boolean isImportant(); //model

    @Override
    public String toString() {
        return date.toString() + " | " + text;
    } //controller

}
