package com.example.nathapong.app57_passdatafromsecondactivitytothefirstactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText edtName, edtEmail, edtUserName, edtPassword;

    public static final String REQUEST_TEXT_FIELD_NAME = "REQUEST_NAME";
    public static final String REQUEST_TEXT_FIELD_EMAIL = "REQUEST_EMAIL";
    public static final String REQUEST_TEXT_FIELD_USER_NAME = "REQUEST_USER_NAME";
    public static final String REQUEST_TEXT_FIELD_PASSWORD = "REQUEST_PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtName = (EditText)findViewById(R.id.edtName);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtUserName = (EditText)findViewById(R.id.edtUserName);
        edtPassword = (EditText)findViewById(R.id.edtPassword);


        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();
                data.putExtra(REQUEST_TEXT_FIELD_NAME, edtName.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_EMAIL, edtEmail.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_USER_NAME, edtUserName.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_PASSWORD, edtPassword.getText().toString());
                setResult(RESULT_OK, data);
                finish();

            }
        });

    }
}
