package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.applligent.bagoapp.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class SignupActivity extends AppCompatActivity {

    Button signup_bnt;
    EditText pro_name, pro_email, pro_pass, pro_com_pass,name;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    InputStream imagepath;

    public static String profiname;
    public static String profiemail;
    public static String profipass ;
    public static String proficompass;
    public static String profiname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        pro_name = findViewById(R.id.signup_name);
        pro_email = findViewById(R.id.signup_email);
        pro_pass = findViewById(R.id.signup_password);
        pro_com_pass = findViewById(R.id.signup_com_pass);
        signup_bnt = findViewById(R.id.signupbtn);
        name=findViewById(R.id.name);

        signup_bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    name.setError("Enter Full Name");
                }else if (pro_name.getText().toString().isEmpty()) {
                    pro_name.setError("Enter Username");
                } else if (pro_email.getText().toString().isEmpty()) {
                    pro_email.setError("Enter Email Address");
                } else if (!pro_email.getText().toString().trim().matches(emailPattern)) {
                    pro_email.setError("Enter Valid Email");
                } else if (pro_pass.getText().toString().isEmpty()) {
                    pro_pass.setError("Enter Valid Pass");
                } else if (pro_pass.getText().toString().length() < 6) {
                    pro_pass.setError("Minimum Langth is 6");
                } else if (pro_com_pass.getText().toString().isEmpty()) {
                    pro_com_pass.setError("ReEnater Password");
                } else if (!pro_com_pass.getText().toString().matches(pro_pass.getText().toString())) {
                    pro_com_pass.setError("Password Not Match");
                } else {
                    signup();
                }
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void signup() {
         profiname = pro_name.getText().toString();
         profiemail = pro_email.getText().toString();
         profipass = pro_pass.getText().toString();
         proficompass = pro_com_pass.getText().toString();
         profiname1 = name.getText().toString();

        startActivity(new Intent(SignupActivity.this,ProfileuploadActivity.class));

    }

    public void signin(View view) {
        startActivity(new Intent(SignupActivity.this, SigninActivity.class));
    }
}
