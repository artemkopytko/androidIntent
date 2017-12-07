package com.artemkopytko.first14lessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.artemkopytko.first14lessons.R.id.buttonUserGoHome;


public class ActivityUser extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegGoHome;
    private TextView textViewUsername;
    private static final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screenuser);

        btnRegGoHome = (Button) findViewById(R.id.buttonUserGoHome);
        btnRegGoHome.setOnClickListener(this);

        textViewUsername = (TextView) findViewById(R.id.textViewUserName);
        // ON ACTIVE SET

        Intent intent = getIntent();

        String username = intent.getStringExtra("username");
        textViewUsername.setText("Hello, " + username);
        String cameFrom = intent.getStringExtra("from");
        if(cameFrom.equals("main")) {
            Toast.makeText(this, "С возвращением!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_LONG).show();
        }


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (data == null) {return;}
//        String username = data.getStringExtra("username");
//        textViewUsername.setText("Hello " + username);
//    }

    public void onClick(View v) {
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case buttonUserGoHome:
                Intent intentHome = new Intent(this, MainActivity.class);
                startActivity(intentHome);
                break;

        }
    }

}
