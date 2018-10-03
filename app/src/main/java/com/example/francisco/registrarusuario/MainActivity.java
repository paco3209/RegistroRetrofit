package com.example.francisco.registrarusuario;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name1, email1, password1,password21;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = (EditText)findViewById(R.id.name);
        email1 = (EditText)findViewById(R.id.email);
        password1 = (EditText)findViewById(R.id.password);
        password21 = (EditText)findViewById(R.id.confirmPassword);

        findViewById(R.id.button).setOnClickListener(this);

        b = (Button)findViewById(R.id.login);
        b.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.button:
                    registro();
                    break;
                case R.id.login:
                    Intent i = new Intent(this, Main2Activity.class);
                    startActivity(i);

                    break;
            }
    }

    private void irLogin() {

    }

    private void registro() {
        String name = name1.getText().toString().trim();
        String email = email1.getText().toString().trim();
        String password = password1.getText().toString().trim();
        String password_confirmation = password21.getText().toString().trim();







        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .crearusuario(name, email, password, password_confirmation);


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {





                    try {
                        Log.d("respuesta",response.body().string());
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this, "registro exitoso", Toast.LENGTH_LONG).show();

                } else if (response.code() == 422) {
                    Toast.makeText(MainActivity.this, "User already exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });



    }
}
