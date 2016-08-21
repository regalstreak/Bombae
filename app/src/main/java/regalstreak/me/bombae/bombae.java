package regalstreak.me.bombae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class bombae extends AppCompatActivity {

    private EditText mobilenotxt;
    private EditText msgtxt;
    private EditText timestxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombae);

        mobilenotxt = (EditText) findViewById(R.id.mobilenotxt);
        msgtxt = (EditText) findViewById(R.id.msgtxt);
        timestxt = (EditText) findViewById(R.id.timestxt);
    }
}
