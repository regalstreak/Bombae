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

    public void startBomb(View view){

        String number,text,times;

        number = mobilenotxt.getText().toString();

        if(number != null && !number.isEmpty()){

            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

        }else{
            Snackbar.make(coordinatorLayout, R.string.number_error, Snackbar.LENGTH_LONG).show();

        }

    }
}
