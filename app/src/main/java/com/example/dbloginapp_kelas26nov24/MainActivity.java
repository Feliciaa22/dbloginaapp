package com.example.dbloginapp_kelas26nov24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    EditText nameEditText, passwordEditText;

    Button loginButton, registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        nameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginbutton);
        registerbutton = findViewById(R.id.registerbutton);

    loginButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String username = nameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (db.checkUser(username,password)) {
                Toast.makeText(MainActivity.this, "Login Succesful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }
    });

        Button registerbutton = findViewById(R.id.registerbutton);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_register.class); // Sesuaikan nama kelas
                startActivity(intent);
            }
        });
    }
}