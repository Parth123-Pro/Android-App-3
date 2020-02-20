package com.example.auctionhub.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.auctionhub.BottomActivity;
import com.example.auctionhub.Forgotpassword.ForgotpasswordActivity;
import com.example.auctionhub.HistoryFragment;
import com.example.auctionhub.R;
import com.example.auctionhub.Registration.RegistrationActivity;
import com.example.auctionhub.UserFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class LoginActivity extends AppCompatActivity {

   TextView t1,t2,t3;
   EditText email,password;
   Button b1;
    String URL_LOGIN = "https://determinate-soap.000webhostapp.com/login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1 =  findViewById(R.id.t1);
        email =  findViewById(R.id.email);
        password = findViewById(R.id.passs);
        b1 =  findViewById(R.id.btnlog);
        t2 = findViewById(R.id.linkrr1);
        t3 = findViewById(R.id.linkfp1);

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ForgotpasswordActivity.class);
                startActivity(intent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();
                if (!mEmail.isEmpty() || !mPass.isEmpty() ){
                    Login(mEmail , mPass);


                }else{
                    email.setError("Please Insert Email");
                    password.setError("Please Inset Password");
                }

            }

        });



    }

    private void Login(final String email, final String password) {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                     try {

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");
                            if (success.equals("1"))
                            {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();

                                  Intent main = new Intent(getApplicationContext(),BottomActivity.class);
                                  main.putExtra("name",name);
                                  main.putExtra("email",email);
                                  startActivity(main);
                                    finish();
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            b1.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this,"Error"+e.toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        b1.setVisibility(View.VISIBLE);

                    }
                })
        {
            protected Map<String,String> getParams()throws AuthFailureError
            {
                Map<String,String> params=new HashMap<>();

                params.put("email",email);
                params.put("password",password);

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}



