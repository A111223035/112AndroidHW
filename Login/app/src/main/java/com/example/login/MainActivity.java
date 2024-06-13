package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String DEFAULT_USERNAME = "A111223035";
    private static final String DEFAULT_PASSWORD = "wenny943";
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.edtAccount);
        editTextPassword = findViewById(R.id.edtPassword);
        buttonLogin = findViewById(R.id.btnSure);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error_message, Toast.LENGTH_SHORT).show();
                } else if (!username.equals(DEFAULT_USERNAME)) {
                    Toast.makeText(MainActivity.this, R.string.USERNAME_error_message, Toast.LENGTH_SHORT).show();
                } else if (!password.equals(DEFAULT_PASSWORD)) {
                    Toast.makeText(MainActivity.this, R.string.PASSWORD_error_message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.login_success_message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
