package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditTweetActivity extends Activity {

    private Tweet tweet;
    public Tweet getTweet() {
        return tweet;
    }

    private EditText editTweetText;
    public EditText getEditTweetText() {
        return editTweetText;
    }

    private Button saveButton;
    public Button getSaveButton() {
        return saveButton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        editTweetText = (EditText) findViewById(R.id.editTweetText); //view
        saveButton = (Button) findViewById(R.id.editTweetSave); //view

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String text = editTweetText.getText().toString(); //controller
                tweet.setText(text); //controller
                Intent returnIntent = new Intent();
                returnIntent.putExtra("editedTweet",tweet);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        tweet = (Tweet) getIntent().getSerializableExtra("tweet");
        editTweetText.setText(tweet.getText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_tweet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
