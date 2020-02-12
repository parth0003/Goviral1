package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.applligent.bagoapp.R;
import com.applligent.bagoapp.VolleyMultipartRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SigninActivity extends AppCompatActivity {

    Button signin;
    EditText edt_email, edt_password;
    String email, password;
    ProgressDialog dialog;
    public static final String URL = "http://157.245.92.253/users/sign_in";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signin = findViewById(R.id.signin);
        edt_email = findViewById(R.id.email);
        edt_password = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Sign Up");
        dialog.setMessage("Please Wait...");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_email.getText().toString().isEmpty()) {
                    edt_email.setError("Enter Email");
                } else if (edt_password.getText().toString().isEmpty()) {
                    edt_password.setError("Enter Password");
                } else {
                    signincall();
                }
            }
        });
    }

    private void signincall() {
        email = edt_email.getText().toString();
        password = edt_password.getText().toString();

        dialog.show();
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, URL,
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        dialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(new String(response.data));

                            if (obj.has("status")) {
                                if (obj.getString("status").equals("200")) {
                                    editor.putString("email", obj.getString("email"));
                                    editor.putString("token", obj.getString("token"));
                                    editor.putString("exp", obj.getString("exp"));
                                    editor.putString("flag", "login");
                                    editor.commit();
                                    startActivity(new Intent(SigninActivity.this, Dashboard.class));
                                    finishAffinity();
                                }
                            } else if (obj.has("error")) {

                                Toast.makeText(SigninActivity.this, "Please Check Email and Password.", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        Toast.makeText(SigninActivity.this, "Please Check Email and Password.", Toast.LENGTH_SHORT).show();
                        Log.e("TAGGotError", "" + error.getMessage());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("email", email);
                hashMap.put("password", password);
                return hashMap;
            }

//            @Override
//            public Map<String, String> getHeaders() {
//                HashMap<String,String> hashMap=new HashMap<>();
//                hashMap.put("Content-Type","application/json");
//                return hashMap;
//            }
        };

        Volley.newRequestQueue(this).add(volleyMultipartRequest);
    }

    public void signup(View view) {
        startActivity(new Intent(SigninActivity.this, SignupActivity.class));
    }


    public void forgotpassword(View view) {
        startActivity(new Intent(SigninActivity.this, ForgotPasswordActivity.class));
    }
}
