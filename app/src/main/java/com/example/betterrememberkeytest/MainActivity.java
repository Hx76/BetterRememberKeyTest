package com.example.betterrememberkeytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText pwd;
    private CheckBox rememeber_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        pwd = findViewById(R.id.password);
        rememeber_pwd = findViewById(R.id.remember_password);

        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        String email1 = pref.getString("email","");
        String password = pref.getString("pwd","");
        email.setText(email1);
        pwd.setText(password);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String Email = email.getText().toString();
        String Pwd = pwd.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("email",Email);
        if (rememeber_pwd.isChecked()) {
            editor.putString("pwd",Pwd);
        }else {
            editor.putString("pwd","");
        }
        editor.apply();
    }
}
