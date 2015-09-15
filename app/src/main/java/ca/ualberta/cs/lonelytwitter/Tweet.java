package ca.ualberta.cs.lonelytwitter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hammadjutt on 2015-09-15.
 */

public abstract class Tweet extends Object implements Tweetable {
    private String text;
    private Date date;
    private ArrayList<Mood> moodList;

    public void setMoodList(ArrayList<Mood> moodList) {
        this.moodList = moodList;
    }

    public void setText(String text) {
        if (text.length() <= 140) {
            this.text = text;
        } else{
            throw new InvalidParameterException("Tweets can't be that long! ");
        }
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tweet(String text) {
        this.text = text;
        this.date = new Date();
    }
    public Tweet(String tweet, Date date) {
        text = tweet;
        this.date = date;
    }

    public abstract Boolean isImportant();

}
