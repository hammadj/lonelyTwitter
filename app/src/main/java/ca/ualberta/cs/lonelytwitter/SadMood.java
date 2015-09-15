package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hammadjutt on 2015-09-15.
 */
public class SadMood extends Mood {
    public SadMood(String mood) {
        super(mood);
    }

    public SadMood(String tweet, Date date) {
        super(tweet, date);
    }

    public String getMoodType() {
        return "sad";
    }
}
