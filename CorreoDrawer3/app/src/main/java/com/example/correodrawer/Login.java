package com.example.correodrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1 = findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextLogin = (EditText) findViewById(R.id.username);
                EditText editTextPassword =(EditText)findViewById(R.id.password);
                SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_PMDM_correo_file), Context.MODE_PRIVATE);
                boolean isLogin=sharedPref.getBoolean(getString(R.string.preferencias_islogin),false);
                Log.i("Logical", String.valueOf(isLogin));
                if (isLogin) {
                    Intent i=new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                }else
                    chg();
            }
        });
    }

    public void chg()
    {
        Intent IntentChanger = new Intent(this, MainActivity.class);
        TextView tl = (EditText)findViewById(R.id.username);
        String email = tl.getText().toString();
        tl = (TextView)findViewById(R.id.password);
        String pass = (String) tl.getText().toString();
        Log.i("Logical", email);
        Log.i("Logical", pass);
        if(email.equals("1234") && pass.equals("1234"))
        {
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_PMDM_correo_file), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.preferencias_email), email);
            editor.putBoolean(getString(R.string.preferencias_islogin), true);
            editor.commit();
            startActivity(IntentChanger);
        }else
        {
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }
    }
}