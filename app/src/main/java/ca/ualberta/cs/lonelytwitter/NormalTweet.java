package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hammadjutt on 2015-09-15.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String text) {
        super(text);
    }

    public NormalTweet(String tweet, Date date) {
        super(tweet, date);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
