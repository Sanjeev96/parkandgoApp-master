package com.dhillon.parkandgo.activities;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.dhillon.parkandgo.R;

import static com.dhillon.parkandgo.R.id.nestedScrollView;

/**
 * Created by Sanjeev Dhillon
 */

public class UserAreaActivity extends AppCompatActivity {
//create variables
    private Spinner dlCostTime;
    private EditText txtReg;
    private EditText txtCode;
    private EditText txtStreetName;
    private Button btnPay;
    private CheckBox cbGPS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_area);

        // REFERENCES ALL VARIABLE TO FIELDS IN LAYOUT
        txtReg = (EditText)findViewById(R.id.txtReg);
        txtCode = (EditText)findViewById(R.id.txtCode);
        txtStreetName = (EditText)findViewById(R.id.txtStreetName);
        dlCostTime = (Spinner)findViewById(R.id.dlCostTime);
        cbGPS = (CheckBox)findViewById(R.id.cbGPS);

        cbGPS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent MapIntent = new Intent(UserAreaActivity.this,MapsActivity.class);
                UserAreaActivity.this.startActivity(MapIntent);
            }
        });



        btnPay = (Button)findViewById(R.id.btnPay);//REFERENCE THE PAY BUTTON*/
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// SETS ONCLICKLISTENER TO LISTEN FOR BUTTON CLICK*/


                if (txtReg.getText().toString().trim().equals("")) {
                    txtReg.setError("required!");
                } else {

                    if ((txtCode.getText().toString().trim().equals("") && !txtStreetName.getText().toString().trim().equals("")) /** if both fields are empty*/
                            ||   // pass to next activity of one of the two is filled*/
                            (!txtCode.getText().toString().trim().equals("") && txtStreetName.getText().toString().trim().equals(""))) {
                        // On button click if conditons are met pass through to payment activity*/
                        Intent payIntent = new Intent(UserAreaActivity.this, PaymentActivity.class);// creates intent to open payment details
                        UserAreaActivity.this.startActivity(payIntent);//Performs intent to open payment page
                    } else {
                        //show message(snackbar) enter either code or street name not both*/
                        Toast.makeText(UserAreaActivity.this, "Enter Code OR Street name", Toast.LENGTH_LONG).show();


                    }
                }



                }


        });
    }
}





