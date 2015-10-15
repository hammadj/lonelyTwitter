package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private EditText bodyText;
    private Button saveButton;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditATweet() {
        //starts lonelyTwitter
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();
        activity.getTweets().clear();

        //user clicks on tweet they want to edit
        bodyText = activity.getBodyText();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText("hamburgers");
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure threads finish

        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure threads finish

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("hamburgers", tweet.getText());


        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);

        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetsList.getChildAt(0);
                oldTweetsList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure threads finish


        // Following was taken from: https://developer.android.com/training/activity-testing/activity-functional-testing.html


        // Validate that EditTweetActivity is started
        final EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("EditTweetActivity is null", receiverActivity);
        assertEquals("Monitor for EditTweetActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        //test that tweet being shown on the edit screen is the tweet we clicked on
        Tweet editTweet = receiverActivity.getTweet();
        assertEquals("Tweet shown on edit screen is not same as tweet clicked", tweet.getText(), editTweet.getText());


        //edit the text of that tweet
        receiverActivity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText = receiverActivity.getEditTweetText();
                bodyText.setText("cheeseburgers");
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure threads finish


        // save our edits
        saveButton = receiverActivity.getSaveButton();
        receiverActivity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure threads finish

        //assert that out edits were saved into the tweet correctly
        editTweet = receiverActivity.getTweet();
        assertEquals("Edits were not saved into tweet correctly", editTweet.getText(), "cheeseburgers");


        //assert that our edits are shown on the screen to the user
        receiverActivity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText = receiverActivity.getEditTweetText();
            }
        });
        getInstrumentation().waitForIdleSync(); //make sure threads finish

        assertEquals("Edits were not shown on the screen to the user", bodyText.getText().toString(), "cheeseburgers");

        // back in the main activity
        assertEquals("Not back in main activity", activity, getActivity());

        //end test - clear data
        receiverActivity.finish();



    }
}