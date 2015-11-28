package abcsofcode.com.lemonaide;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.androidquery.AQuery;

import org.json.JSONException;
import org.json.JSONObject;

public class AlertActivity extends Activity {

    TextView tvMsg;
    private AQuery aq;
    // Progress Dialog bar object
    ProgressDialog prgDialog;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);


        aq = new AQuery(this);
        String json = getIntent().getStringExtra("greetjson");
        SharedPreferences prefs = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        tvMsg = (TextView) findViewById(R.id.message);

        // Check if Google Play Service is installed in Device
        // Play services is needed to handle GCM stuffs

        // When json is not null
        if (json != null) {
            try {
                JSONObject jsonObj = new JSONObject(json);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("greetmsg", jsonObj.getString("greetMsg"));
                editor.commit();

                tvMsg.setText(prefs.getString("greetmsg", ""));

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        // When Json is null
        else if (!"".equals(prefs.getString("greetmsg", "") != null)) {
            tvMsg.setText(prefs.getString("greetmsg", ""));

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
