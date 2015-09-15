package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

/**
 * Created by hammadjutt on 2015-09-15.
 */
public interface Tweetable {
    public void setText(String text);
    public String getText() throws IOException;


}
