package abcsofcode.com.lemonaide;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidquery.AQuery;

public class ProfileActivity extends Activity {

    TextView emailET;
    private AQuery aq;
    // Progress Dialog bar object
    ProgressDialog prgDialog;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        String id = intent.getStringExtra("regId");
        Log.e("ARDELL", "regId = " + id);
        /*
        aq = new AQuery(this);
        String json = getIntent().getStringExtra("greetjson");
        SharedPreferences prefs = getSharedPreferences("UserDetails",
                Context.MODE_PRIVATE);
        emailET = (TextView) findViewById(R.id.greetingmsg);

        // Check if Google Play Service is installed in Device
        // Play services is needed to handle GCM stuffs

        // When json is not null
        if (json != null) {
            try {
                JSONObject jsonObj = new JSONObject(json);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("greetimgurl", jsonObj.getString("greetImgURL"));
                editor.putString("greetmsg", jsonObj.getString("greetMsg"));
                editor.commit();

                emailET.setText(prefs.getString("greetmsg", ""));
                // Render Image read from Image URL using aquery 'image' method
                aq.id(R.id.greetimg)
                        .progress(R.id.progress)
                        .image(prefs.getString("greetimgurl", ""), true, true,
                                0, 0, null, AQuery.FADE_IN);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        // When Json is null
        else if (!"".equals(prefs.getString("greetimgurl", "")) && !"".equals(prefs.getString("greetmsg", "") != null)) {
            emailET.setText(prefs.getString("greetmsg", ""));
            aq.id(R.id.greetimg)
                    .progress(R.id.progress)
                    .image(prefs.getString("greetimgurl", ""), true, true, 0,
                            0, null, AQuery.FADE_IN);
        }
        */
    }

    // When Application is resumed, check for Play services support to make sure
    // app will be running normally
    @Override
    protected void onResume() {
        super.onResume();
    }

}
