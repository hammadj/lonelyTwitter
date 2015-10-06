package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by joshua2 on 9/29/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testHoldsStuff() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertSame(list.getMostRecentTweet(), tweet);
    }

    public void testHoldsManyThings() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertEquals(list.count(), 1);
        list.add(new NormalTweet("test"));
        assertEquals(list.count(), 2);
    }

    private Boolean weWereNotified;

    public void myNotify(MyObservable observable) {
        weWereNotified = Boolean.TRUE;

    }

    public void testObservable() {
        TweetList list = new TweetList();
        list.addObserver(this);
        Tweet tweet = new NormalTweet("Test");
        weWereNotified = Boolean.FALSE;
        list.add(tweet);
        assertTrue(weWereNotified);
    }

    public void testModifyTweetList(){
        TweetList list = new TweetList();
        list.addObserver(this);
        Tweet tweet = new NormalTweet("Test");
        list.add(tweet);
        weWereNotified = Boolean.FALSE;
        tweet.setText("Different Text");

        assertTrue(weWereNotified);

    }

}