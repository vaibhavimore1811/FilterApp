package com.kotakloan.filterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText etdUserName,etdPassword;
    AppCompatButton btnLogin;
    String SignInEmail,SignInPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }


    private void initView() {
        etdUserName = findViewById(R.id.edtUserName);
        etdPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLogin:
                    if(isUserValidate()){
                        if(SignInEmail.equalsIgnoreCase("admin@gmail.com") && SignInPassword.equalsIgnoreCase("Admin@123"))
                        {
                            SignInMethod();

                        }else {
                            Toast.makeText(this, "Enter right credentials ", Toast.LENGTH_SHORT).show();
                        }

                    }

                break;


        }
    }



    private boolean isUserValidate() {
        SignInEmail = Objects.requireNonNull(etdUserName.getText()).toString().trim();
        SignInPassword = Objects.requireNonNull(etdPassword.getText()).toString().trim();

        if (SignInEmail.isEmpty()) {
            etdUserName.requestFocus();
            etdUserName.setError(getResources().getString(R.string.empty_user_name_error));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(SignInEmail).matches()) {
            etdUserName.requestFocus();
            etdUserName.setError(getResources().getString(R.string.valid_email_error));
        } else if (SignInPassword.isEmpty()) {
            etdPassword.requestFocus();
            etdPassword.setError(getResources().getString(R.string.empty_password_error));
        }  else {
            return true;
        }

        return false;
    }
    public void SignInMethod()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("FilterApp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin", true);
        editor.commit();
        Intent home = new Intent(LoginActivity.this, FilterScreenActivity.class);
        startActivity(home);
        finish();


    }


}