package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */
public class NormalTweet extends Tweet { //model
    public NormalTweet(String tweet, Date date) {
        super(tweet, date);
    } //model

    public NormalTweet(String tweet) {
        super(tweet);
    } //model

    public Boolean isImportant() {
        return Boolean.FALSE;
    } //model
}
