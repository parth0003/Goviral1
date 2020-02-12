package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.applligent.bagoapp.MainActivity;
import com.applligent.bagoapp.R;
import com.applligent.bagoapp.VolleyMultipartRequest;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.takisoft.datetimepicker.DatePickerDialog;
import com.takisoft.datetimepicker.widget.DatePicker;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileuploadActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSIONS = 100;
    private static final int PICK_IMAGE_REQUEST =1 ;
    private Bitmap bitmap;
    private String filePath;
    TextView mTextView;
    CircleImageView mCircleImageView;
    DatePickerDialog datePickerDialog;
    RadioButton male,female;

    ProgressDialog dialog;

    public static final String URL = "http://157.245.92.253/users";

    boolean imageflag=false,dateflag=false;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileupload);

        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        mTextView=findViewById(R.id.dob);
        mCircleImageView=findViewById(R.id.image);
        datePickerDialog=new DatePickerDialog(ProfileuploadActivity.this);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                mTextView.setText(month+"/"+dayOfMonth+"/"+year);
                dateflag=true;
            }
        });

        sharedPreferences=getSharedPreferences("demo",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        dialog=new ProgressDialog(this);
        dialog.setTitle("Sign Up");
        dialog.setMessage("Please Wait...");

        mCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(ProfileuploadActivity.this)
                        .withPermissions(
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE
                        ).withListener(new MultiplePermissionsListener() {
                    @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted())
                        {
                            showFileChooser();
                        }
                    }
                    @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
            }
        });
    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    public void selectdate(View view) {
        datePickerDialog.show();
    }

    public void uploadprofile(View view) {
        if (!imageflag)
        {
            Toast.makeText(this, "Select Image", Toast.LENGTH_SHORT).show();

        }else if (!dateflag)
        {
            Toast.makeText(this, "Select Date of birth", Toast.LENGTH_SHORT).show();
        }else
        {
            uploadBitmap(bitmap);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri picUri = data.getData();
            filePath = getPath(picUri);
            if (filePath != null) {
                try {

                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), picUri);
                    imageflag=true;
                    mCircleImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Toast.makeText(
                        ProfileuploadActivity.this,"no image selected",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }


    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }




    private void uploadBitmap(final Bitmap bitmap) {

        dialog.show();
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, URL,
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        dialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(new String(response.data));
                            if (obj.getString("status").equals("unprocessable_entity"))
                            {
                                JSONArray jsonArray=obj.getJSONArray("errors");
                                Toast.makeText(ProfileuploadActivity.this, jsonArray.getString(0), Toast.LENGTH_SHORT).show();
                                if (jsonArray.getString(0).equals("Email has already been taken"))
                                {
                                    onBackPressed();
                                }else if (jsonArray.getString(0).equals("Username has already been taken"))
                                {
                                    onBackPressed();
                                }else if (jsonArray.getString(0).equals("User age should be atleast 18 years old"))
                                {
                                }
                            }else if (obj.getString("status").equals("200"))
                            {
                                editor.putString("email",obj.getString("email"));
                                editor.putString("username",obj.getString("username"));
                                editor.putString("flag","login");
                                editor.commit();

                                startActivity(new Intent(ProfileuploadActivity.this,Dashboard.class));
                                finishAffinity();
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
                        Log.e("TAGGotError",""+error.getMessage());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("username",SignupActivity.profiname);
                hashMap.put("email",SignupActivity.profiemail);
                hashMap.put("password",SignupActivity.profipass);
                hashMap.put("password_confirmation",SignupActivity.proficompass);
                hashMap.put("dob",mTextView.getText().toString());
                if (male.isChecked())
                {
                    hashMap.put("gender","Male");
                }else
                {
                    hashMap.put("gender","Female");
                }

                hashMap.put("name",SignupActivity.profiname1);
                return hashMap;
            }

            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                long imagename = System.currentTimeMillis();
                params.put("avatar", new DataPart(imagename + ".png", getFileDataFromDrawable(bitmap)));
                return params;
            }
        };

        Volley.newRequestQueue(this).add(volleyMultipartRequest);
    }

}
