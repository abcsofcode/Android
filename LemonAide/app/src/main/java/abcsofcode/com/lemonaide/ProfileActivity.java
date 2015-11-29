package abcsofcode.com.lemonaide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    TextView tvName;
    TextView tvCar;

    public static final String NAME_ID = "nameId";
    //public static final String EMAIL_ID = "emailId";
    public static final String CAR_LIST = "carList";
    //public static final String MAKE_ID = "makeId";
    //public static final String MODEL_ID = "modelId";
    //public static final String YEAR_ID = "yearId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        SharedPreferences prefs = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

        String name = prefs.getString(NAME_ID, "");
        String carList = prefs.getString(CAR_LIST, "");


        tvName = (TextView) findViewById(R.id.profileName);
        tvName.setText("Hello " + name + "!");

        //display car to monitor
        tvCar = (TextView) findViewById(R.id.profileCar);
        tvCar.setText("Cars monitored: \n" + carList);



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
