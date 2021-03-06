package com.example.ryann9309.cassera.Landing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.ryann9309.cassera.Util.API_GET;
import com.example.ryann9309.cassera.LoggedIn.LoggedInHomeActivity;
import com.example.ryann9309.cassera.R;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    //region Fields
    private EditText mUserName, mPassword;
    private Button mLogin, mCancel;
    //endregion

    //region Protected
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI();
    }
    //endregion

    //region Private
    private void setupUI() {
        mLogin = (Button)findViewById(R.id.button_MainActivity_Login);
        mCancel = (Button)findViewById(R.id.button_MainActivity_Cancel);
        mUserName = (EditText)findViewById(R.id.editText_MainActivity_Username);
        mPassword = (EditText)findViewById(R.id.editText_MainActivity_Password);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textPresent(mUserName) && textPresent(mPassword))
                    API_GET.getSubscriptions(getApplicationContext(), mUserName.getText().toString(), mPassword.getText().toString(), new API_GET.JSONResponse() {
                        @Override
                        public void onSuccess(JSONObject object) {
                            Intent i = new Intent(getApplicationContext(), LoggedInHomeActivity.class);
                            i.putExtra(LoggedInHomeActivity.EXTRA_JSON_OBJECT, object.toString());
                            startActivity(i);
                        }
                    });
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
            editText.setError(getString(R.string.loginActivity_EmptyEditTextWarning));
            return false;
        }
        return true;
    }
    //endregion
}
