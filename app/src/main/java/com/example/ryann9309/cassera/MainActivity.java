package com.example.ryann9309.cassera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUserName, mPassword;
    private Button mLogin, mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        mLogin = (Button)findViewById(R.id.button_MainActivity_Login);
        mCancel = (Button)findViewById(R.id.button_MainActivity_Cancel);
        mUserName = (EditText)findViewById(R.id.editText_MainActivity_Username);
        mPassword = (EditText)findViewById(R.id.editText_MainActivity_Password);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textPresent(mUserName) && textPresent(mPassword)) {
                    mUserName.setText("");
                    mPassword.setText("");
                    Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_LONG).show();
                }
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private Boolean textPresent(EditText editText) {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            editText.setError("cannot be empty");
            return false;
        }
        return true;
    }
}
