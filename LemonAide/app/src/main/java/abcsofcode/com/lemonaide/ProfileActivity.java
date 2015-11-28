package abcsofcode.com.lemonaide;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.androidquery.AQuery;

public class ProfileActivity extends Activity {

    TextView tvMsg;
    private AQuery aq;
    // Progress Dialog bar object
    ProgressDialog prgDialog;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //display name

        //display cars to monitor

        //add car button below

    }

    public void clickAddBtn(View view) {

        Intent i = new Intent(this, AddCarActivity.class);
        startActivity(i);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
