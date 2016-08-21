package regalstreak.me.bombae;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class bombae extends AppCompatActivity {

    private EditText mobilenotxt;
    private EditText msgtxt;
    private EditText timestxt;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombae);

        mobilenotxt = (EditText) findViewById(R.id.mobilenotxt);
        msgtxt = (EditText) findViewById(R.id.msgtxt);
        timestxt = (EditText) findViewById(R.id.timestxt);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl1);
    }

    public void checkEmpty(View view){

        // Declare the strings
        String number,text,times;

        // Start by getting the mobile number.
        number = mobilenotxt.getText().toString();

        if(number != null && !number.isEmpty()){

            // Number wasn't empty. Get the text message to send.
            text = msgtxt.getText().toString();

            if(text != null && !text.isEmpty()){
                // Text wasn't empty. Get the number of times.
                times = timestxt.getText().toString();

                if(times != null && !times.isEmpty()){
                    // Times wasn't empty. Alert the bomber.
                    Toast.makeText(this, "More code will be placed here lol.", Toast.LENGTH_LONG).show();
                    // TODO: Write more here
                }
                else{
                    // Times was empty, throw a snackbar.
                    Snackbar.make(coordinatorLayout, R.string.times_error, Snackbar.LENGTH_LONG).show();
                }
            }
            else{
                // Text was empty, throw a snackbar.
                Snackbar.make(coordinatorLayout, R.string.text_error, Snackbar.LENGTH_LONG).show();
            }
        }
        else{
            // Number was empty, throw a snackbar.
            Snackbar.make(coordinatorLayout, R.string.number_error, Snackbar.LENGTH_LONG).show();
        }
    }
}
