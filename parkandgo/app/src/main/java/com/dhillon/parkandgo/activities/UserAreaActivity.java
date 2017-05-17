package com.dhillon.parkandgo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.dhillon.parkandgo.R;

/**
 * Created by Sanjeev Dhillon on 26/02/2017.
 */

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_area);

        final Button btnPaydets = (Button) findViewById(R.id.btnPaydets);

        btnPaydets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payIntent = new Intent(UserAreaActivity.this, PaymentActivity.class);// creates intent to open payment details
                UserAreaActivity.this.startActivity(payIntent);//Performs intent to open payment page
            }
        });
    }
}
