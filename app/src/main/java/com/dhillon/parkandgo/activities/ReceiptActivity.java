package com.dhillon.parkandgo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dhillon.parkandgo.R;


/**
 * Created by Sanjeev Dhillon
 */

public class ReceiptActivity extends AppCompatActivity {

// create variables (TextViews would be used if payment details did display in message, this did not work)
    private TextView tvReg;
    private TextView tvCost;
    private TextView tvCode;
    private TextView tvStreetName;
    private Button btnlogout;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        getSupportActionBar().hide();

        btnlogout = (Button) findViewById(R.id.btnLogOut);
// displays message if all previous stages are successful
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Payment for parking successful! E-mail receipt sent").create().show();

        //logs user out of account
        btnlogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent LoginOutIntent = new Intent(ReceiptActivity.this,LoginActivity.class);
                ReceiptActivity.this.startActivity(LoginOutIntent);
            }
        });




    }
}
