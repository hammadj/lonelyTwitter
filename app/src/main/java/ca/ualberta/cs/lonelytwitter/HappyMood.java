package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hammadjutt on 2015-09-15.
 */
public class HappyMood extends Mood {

    public HappyMood(String mood) {
        super(mood);
    }

    public HappyMood(String tweet, Date date) {
        super(tweet, date);
    }

    public String getMoodType() {
        return "happy";
    }
}
