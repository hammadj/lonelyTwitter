package ca.ualberta.cs.lonelytwitter;

import java.security.InvalidParameterException;
import java.util.Date;

/**
 * Created by hammadjutt on 2015-09-15.
 */
public abstract class Mood extends Object {
    private String mood;
    private Date date;


    public void setMood(String mood) {
        mood = mood.toLowerCase();
        if (mood == "happy" || mood == "sad") {
            this.mood = mood;
        } else{
            throw new InvalidParameterException("Tweets can't be that long! ");
        }
    }
    public String getMood() {
        return mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mood(String mood) {
        this.mood = mood;
        this.date = new Date();
    }
    public Mood(String tweet, Date date) {
        mood = tweet;
        this.date = date;
    }

    public abstract String getMoodType();
}

