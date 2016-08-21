package regalstreak.me.bombae;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.assent.Assent;
import com.afollestad.assent.AssentCallback;
import com.afollestad.assent.PermissionResultSet;

public class bombae extends AppCompatActivity {

    private EditText mobilenotxt;
    private EditText msgtxt;
    private EditText timestxt;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombae);
        Assent.setActivity(this, this);
        mobilenotxt = (EditText) findViewById(R.id.mobilenotxt);
        msgtxt = (EditText) findViewById(R.id.msgtxt);
        timestxt = (EditText) findViewById(R.id.timestxt);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl1);
        if (!Assent.isPermissionGranted(Assent.SEND_SMS)) {
            // The if statement checks if the permission has already been granted before
            Assent.requestPermissions(new AssentCallback() {
                @Override
                public void onPermissionResult(PermissionResultSet result) {
                    // Permission granted or denied
                }
            }, 69, Assent.SEND_SMS);
        }
    }

    // Declare the strings (Used globally)
    public String number,text,times;

    public void checkEmpty(View view){

        // Start by getting the mobile number.
        number = mobilenotxt.getText().toString();

        if(!number.equals("") && !number.isEmpty()){

            // Number wasn't empty. Get the text message to send.
            text = msgtxt.getText().toString();

            if(!text.equals("") && !text.isEmpty()){
                // Text wasn't empty. Get the number of times.
                times = timestxt.getText().toString();

                if(!times.equals("") && !times.isEmpty()){
                    // Times wasn't empty. Alert the bomber.
                    showAlert(coordinatorLayout);
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

    public void showAlert(View view){

        // Format the string
        Resources res = getResources();
        String alert1 = String.format(res.getString(R.string.alert_msg), times, number);
        CharSequence alert = Html.fromHtml(alert1);

        // Show an alert to the guy who wanna bomb the shiz.
        AlertDialog.Builder warning = new AlertDialog.Builder(this);
        warning.setTitle(R.string.warning)
               .setMessage(alert)
               .setIcon(R.drawable.ic_warning_grey_500_18dp)
               .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       // Yes is pressed. Start the bombing.
                       startBomb(coordinatorLayout);

                   }
               })
               .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       // No is pressed. Do nothing.
                   }
               })
               .show();
    }

    public void startBomb(View view){
        // Show a toast that we have started
        Toast.makeText(this, R.string.start_bomb, Toast.LENGTH_LONG).show();

        // Initialise smsManager
        SmsManager smsManager = SmsManager.getDefault();

        // Convert times string into an integer
        int timesint = Integer.parseInt(times);

        int i=0;
        while( i <= timesint ){
            smsManager.sendTextMessage(number, null, text, null, null);
            i++;
        }

        Snackbar.make(coordinatorLayout, R.string.done_bomb, Snackbar.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Updates the activity every time the Activity becomes visible again
        Assent.setActivity(this, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Cleans up references of the Activity to avoid memory leaks
        if (isFinishing())
            Assent.setActivity(this, null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Lets Assent handle permission results, and contact your callbacks
        Assent.handleResult(permissions, grantResults);
    }


}
