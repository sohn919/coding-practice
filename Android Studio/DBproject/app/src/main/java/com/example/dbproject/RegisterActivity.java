package com.example.dbproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText id_id, id_pass;
    private Button ex_buttonregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //아이디 값 찾아주기기
        id_id = findViewById(R.id.id_id);
        id_pass = findViewById(R.id.id_pass);
        ex_buttonregister = findViewById(R.id.ex_buttonregister);

        ex_buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText에 현재 입력 되어 있는 값을 get 해온다.
                String userID = id_id.getText().toString();
                String userPass = id_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try { //회원등록에 성공한 경우
                            JSONObject jsonObject = new JSONObject(response);
                            //boolean success = jsonObject.getBoolean(name: "success");
                            if(true) {
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else { //회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                //서버로 Volley를 이용해서 요청을 함
                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);


            }
        });
    }
}