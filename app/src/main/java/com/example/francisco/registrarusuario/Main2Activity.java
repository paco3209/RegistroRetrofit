package com.example.francisco.registrarusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText editEmail, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        editEmail = (EditText)findViewById(R.id.email);
        editPassword = (EditText)findViewById(R.id.password);

        findViewById(R.id.button2).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                login();
                break;
        }
    }

    private void login() {

        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        Call<ResponseBody> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .login(email,password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    Intent a = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(a);
                }
                else {
                    Toast.makeText(Main2Activity.this,"El usuario o contraseña es invalido",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Main2Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
