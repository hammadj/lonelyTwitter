package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */
public class ImportantTweet extends Tweet {
    public ImportantTweet(String tweet, Date date) { //model
        super(tweet, date);
        this.setText(tweet);
        this.date = date;
    }

    public ImportantTweet(String tweet) {
        super(tweet);
    } //model

    public Boolean isImportant() {
        return Boolean.TRUE;
    } //model

    @Override
    public String getText() {
        return "!!!" + super.getText();
    } //model

}
