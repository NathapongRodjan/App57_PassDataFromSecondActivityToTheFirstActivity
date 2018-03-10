package com.example.nathapong.app57_passdatafromsecondactivitytothefirstactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtName, txtEmail, txtUserName, txtPassword;
    Button btnMove;

    private static final int REQUEST_CODE_MOVE = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtUserName = (TextView)findViewById(R.id.txtUserName);
        txtPassword = (TextView)findViewById(R.id.txtPassword);
        btnMove = (Button)findViewById(R.id.btnMove);

        btnMove.setOnClickListener(MainActivity.this);

    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        startActivityForResult(intent, REQUEST_CODE_MOVE);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MOVE && resultCode == RESULT_OK){

            String name = data.getStringExtra(SecondActivity.REQUEST_TEXT_FIELD_NAME);
            String email = data.getStringExtra(SecondActivity.REQUEST_TEXT_FIELD_EMAIL);
            String userName = data.getStringExtra(SecondActivity.REQUEST_TEXT_FIELD_USER_NAME);
            String password = data.getStringExtra(SecondActivity.REQUEST_TEXT_FIELD_PASSWORD);

            txtName.setText(name);
            txtEmail.setText(email);
            txtUserName.setText(userName);
            txtPassword.setText(password);

        }


    }
}
