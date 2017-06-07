package com.dhillon.parkandgo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.dhillon.parkandgo.R;
import com.dhillon.parkandgo.helpers.InputValidation;

import com.dhillon.parkandgo.model.User;
import com.dhillon.parkandgo.sql.DatabaseHelper;


/**
 * Created by Sanjeev Dhillon
 */


public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = PaymentActivity.this;
// create variables
    private NestedScrollView nestedScrollView;

    private TextInputLayout txtLayoutCardNum;
    private TextInputLayout txtLayoutExpiryDate;
    private TextInputLayout txtLayoutSecurityCode;

    private TextInputEditText txtEditCardNum;
    private TextInputEditText txtEditExpiryDate;
    private TextInputEditText txtEditSecuirtyCode;

    private AppCompatButton btnPaydetsConfirm;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }


    //  This method is to initialize views (link variable names to fields on layouts)
    private void initViews() {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        txtLayoutCardNum = (TextInputLayout) findViewById(R.id.txtLayoutCardNum);
        txtLayoutExpiryDate = (TextInputLayout) findViewById(R.id.txtLayoutExpiryDate);
        txtLayoutSecurityCode = (TextInputLayout) findViewById(R.id.txtLayoutSecurityCode);

        txtEditCardNum = (TextInputEditText) findViewById(R.id.txtEditCardNum);
        txtEditExpiryDate = (TextInputEditText) findViewById(R.id.txtEditExpiryDate);
        txtEditSecuirtyCode = (TextInputEditText) findViewById(R.id.txtEditSecurityCode);

        btnPaydetsConfirm = (AppCompatButton) findViewById(R.id.btnPaydetsConfirm);
    }

    //Method is to initialize Listeners
    private void initListeners() {
        btnPaydetsConfirm.setOnClickListener(this);

    }

    // Method is to initialize objects to be used
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }


    //Implemented method is to listen the click on view
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnPaydetsConfirm:
                postDataToSQLite();
                break;


        }
    }


    //Method is to validate the input text fields and post data to SQLite database file

    private void postDataToSQLite() {

        if (!inputValidation.isInputEditTextFilled(txtEditCardNum, txtLayoutCardNum, getString(R.string.error_message_cardnum))) {

            return;
        }
        if (!inputValidation.isInputEditTextFilled(txtEditExpiryDate, txtLayoutExpiryDate, getString(R.string.error_message_exiprydate))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(txtEditSecuirtyCode, txtLayoutSecurityCode, getString(R.string.error_message_securitycode))) {
            return;
        } else {

            // Places data entered into EditextFields into db if validations is successful.


           // user.setCardnum(txtEditCardNum.getText().toString().trim());
           //user.setExpirydate(txtEditExpiryDate.getText().toString().trim());
           //user.setSecuritycode(txtEditSecuirtyCode.getText().toString().trim());

            //Attempt to validate fields interms of required characters(unsuccessful will come back to later)
            user.setCardnum(txtEditCardNum.getText().length()!=16);
            user.setExpirydate(txtEditExpiryDate.getText().length()!=5);
            user.setSecuritycode(txtEditSecuirtyCode.getText().length()!=3);

            databaseHelper.addUser(user);

            // show success message that record saved successfully
           // Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();


            //  Navigate to PaymentActivity
            Intent intentPayConfirm = new Intent(getApplicationContext(), ReceiptActivity.class);
            startActivity(intentPayConfirm);
        }

    }
}


