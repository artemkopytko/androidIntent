package com.artemkopytko.first14lessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import static com.artemkopytko.first14lessons.R.id.buttonLogIn;
import static com.artemkopytko.first14lessons.R.id.buttonMainSignup;

//import android.view.View.
//import android.content.DialogInterface.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

//    private TextView myTextView;
//    private Button myBtn;
    private Button btnLogIn;
    private Button btnSignUp;
    private EditText inputMainUsername;
    private EditText inputMainPassword;
    AuthDictionary authDictionary = new AuthDictionary();
    protected Map<String, String> dictionaryInt = AuthDictionary.keyMap;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screenmain);
//        Log.d(TAG, "найдем View-элементы");

        btnLogIn = (Button) findViewById(R.id.buttonLogIn);
        btnLogIn.setOnClickListener(this);
        btnSignUp = (Button) findViewById(R.id.buttonMainSignup);
        btnSignUp.setOnClickListener(this);
        inputMainUsername = (EditText) findViewById(R.id.editTextName);
        inputMainPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dictionaryInt = AuthDictionary.keyMap;
        Log.d(TAG, dictionaryInt.toString());
    }

    public void onClick(View v) {
//        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case buttonLogIn:
                Log.d(TAG, dictionaryInt.toString());
                Intent intentUser = new Intent("android.intent.action.dashboard");

                String inputUsername = inputMainUsername.getText().toString();
                String inputPassword = inputMainPassword.getText().toString();

                if( inputUsername.length() != 0 && inputPassword.length() != 0) {
                    if (dictionaryInt.containsKey(inputUsername)) {
                        String pwd = dictionaryInt.get(inputUsername);
                        if (pwd.equals(inputPassword)) {
                            intentUser.putExtra("username", inputMainUsername.getText().toString());
                            startActivity(intentUser);
                        } else {
                            Toast.makeText(this, "Неверный логин/пароль", Toast.LENGTH_LONG).show();
                            Log.d(TAG, "Неверный логин/пароль");
                        }
                    }
                    else {
                        Toast.makeText(this, "Такого логина не существует", Toast.LENGTH_LONG).show();
                        Log.d(TAG, "Такого логина не существует");
                    }
                } else {
                    Toast.makeText(this, "Не введен логин/пароль", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "Не введен логин/пароль");
                }
                break;
            case buttonMainSignup:
                Intent intentReg = new Intent("android.intent.action.signup");
                startActivity(intentReg);
                break;
        }
    }
}
