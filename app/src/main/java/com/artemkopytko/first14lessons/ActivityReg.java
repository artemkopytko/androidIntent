package com.artemkopytko.first14lessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.artemkopytko.first14lessons.R.id.buttonRegSignup;

public class ActivityReg extends AppCompatActivity implements View.OnClickListener {


    private Button btnRegSignUp;
    private EditText editTextRegLogin;
    private EditText editTextRegPassword;

    AuthDictionary authDictionary = new AuthDictionary();

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screenreg);

        btnRegSignUp = (Button) findViewById(R.id.buttonRegSignup);
        btnRegSignUp.setOnClickListener(this);

        editTextRegLogin = (EditText) findViewById(R.id.editTextRegUsername);
        editTextRegLogin.setOnClickListener(this);

        editTextRegPassword = (EditText) findViewById(R.id.editTextRegPwd);
        editTextRegPassword.setOnClickListener(this);
    }

    public void onClick(View v) {
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case buttonRegSignup:
                Intent intentGoUser = new Intent(this, ActivityUser.class);

                String inputUsername = editTextRegLogin.getText().toString();
                String inputPassword = editTextRegPassword.getText().toString();


                if (inputUsername.length() != 0 && inputPassword.length() != 0) {
                    AuthDictionary.keyMap.put(inputUsername, inputPassword);

                    intentGoUser.putExtra("username", editTextRegLogin.getText().toString());
                    intentGoUser.putExtra("from", "signup");
//                    setResult(RESULT_OK, intentGoUser);
//                    finish();
                    startActivity(intentGoUser);
                } else {
                    Toast.makeText(this, "Неверно введен логин/пароль", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "Неверно введен логин/пароль");
                }
                break;
        }
    }
}
