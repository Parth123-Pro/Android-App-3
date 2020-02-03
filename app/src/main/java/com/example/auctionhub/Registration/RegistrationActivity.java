package com.example.auctionhub.Registration;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.auctionhub.Login.LoginActivity;
import com.example.auctionhub.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
public class RegistrationActivity extends AppCompatActivity {

    TextView t11, t22;
    EditText name, email, pass, cpass;
    Button regBtn;
    String URL_REGIST = "http://172.16.5.97/Auction/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        t11 = findViewById(R.id.rt1);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.passs11);
        cpass = findViewById(R.id.edtcp);
        regBtn = findViewById(R.id.btnreg);
        t22=findViewById(R.id.linklog1);
        t22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

         regBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String mName=name.getText().toString().trim();
                 String mEmail=email.getText().toString().trim();
                 String mPass=pass.getText().toString().trim();
                 if (!mEmail.isEmpty() || !mPass.isEmpty() || !mName.isEmpty()){
                     Regist();

                 }else{
                     name.setError("Please Insert Name");
                     email.setError("Please Insert Email");
                     pass.setError("Please Inset Password");
                 }
             }
         });



    }

    public void Regist(){
        regBtn.setVisibility(View.GONE);
        final String name=this.name.getText().toString().trim();
        final String email=this.email.getText().toString().trim();
        final String password=this.pass.getText().toString().trim();
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            String success = jsonObject.getString("Success");

                            if(success.equals("1")){
                                Toast.makeText(RegistrationActivity.this, "Register Success!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(RegistrationActivity.this, "Register Error!" +e.toString(), Toast.LENGTH_SHORT).show();

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistrationActivity.this, "Register Error!" +error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
            {
            @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("password",password);
                return params;
                }
            };
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}














