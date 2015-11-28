package abcsofcode.com.lemonaide;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class AddCarActivity extends Activity {

    ProgressDialog prgDialog;
    RequestParams params = new RequestParams();

    EditText makeET;
    EditText modelET;
    EditText yearET;

    Context applicationContext;

    public static final String MAKE_ID = "makeId";
    public static final String MODEL_ID = "modelId";
    public static final String YEAR_ID = "yearId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        applicationContext = getApplicationContext();
        makeET = (EditText) findViewById(R.id.carMake);
        modelET = (EditText) findViewById(R.id.carModel);
        yearET = (EditText) findViewById(R.id.carYear);

        prgDialog = new ProgressDialog(this);
        // Set Progress Dialog Text
        prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
        prgDialog.setCancelable(false);

        //selectable items from lists? or nah for today??
    }

    public void clickSaveBtn(View view) {

        String makeID = makeET.getText().toString();
        String modelID = modelET.getText().toString();
        String yearID = yearET.getText().toString();

        if (!TextUtils.isEmpty(makeID) && !TextUtils.isEmpty(modelID) && !TextUtils.isEmpty(yearID)) {

            // Register Device in GCM Server
            storeRegIdinSharedPref(applicationContext, makeID, modelID, yearID);

        }
        else {
            Toast.makeText(applicationContext, "Please enter all information",
                    Toast.LENGTH_LONG).show();
        }

    }

    // Store RegId and Email entered by User in SharedPref
    private void storeRegIdinSharedPref(Context context, String makeID, String modelID, String yearID) {

        SharedPreferences prefs = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(MAKE_ID, makeID);
        editor.putString(MODEL_ID, modelID);
        editor.putString(YEAR_ID, yearID);
        editor.commit();

        storeRegIdinServer(makeID, modelID, yearID);

    }

    // Share RegID and Email ID with GCM Server Application (Php)
    private void storeRegIdinServer(String makeID, String modelID, String yearID) {

        prgDialog.show();
        params.put("makeId", makeID);
        params.put("modelId", modelID);
        params.put("yearId", yearID);
        System.out.println("Make = " + makeID + " Model = " + modelID + " Year = " + yearID);
        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(ApplicationConstants.CAR_ADD_URL, params,
                new AsyncHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        // When the response returned by REST has Http
                        // response code '200'

                        // Hide Progress Dialog
                        prgDialog.hide();
                        if (prgDialog != null) {
                            prgDialog.dismiss();
                        }
                        Toast.makeText(applicationContext,
                                "Shared on web app ",
                                Toast.LENGTH_LONG).show();
                        /*
                        Intent i = new Intent(applicationContext,
                                AlertActivity.class);
                        i.putExtra("regId", regId);
                        startActivity(i);

                        finish();
                        */
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        // When the response returned by REST has Http
                        // response code other than '200' such as '404',
                        // '500' or '403' etc

                        // Hide Progress Dialog
                        prgDialog.hide();
                        if (prgDialog != null) {
                            prgDialog.dismiss();
                        }
                        // When Http response code is '404'
                        if (statusCode == 404) {
                            Toast.makeText(applicationContext,
                                    "Requested resource not found",
                                    Toast.LENGTH_LONG).show();
                        }
                        // When Http response code is '500'
                        else if (statusCode == 500) {
                            Toast.makeText(applicationContext,
                                    "Something went wrong at server end",
                                    Toast.LENGTH_LONG).show();
                        }
                        // When Http response code other than 404, 500
                        else {
                            Toast.makeText(
                                    applicationContext,
                                    "Unexpected Error occcured! [Most common Error: Device might "
                                            + "not be connected to Internet or remote server is not up and running], check for other errors as well",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }


}
