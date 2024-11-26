package com.example.dbloginapp_kelas26nov24;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class activity_register extends AppCompatActivity {

    DatabaseHelper db;
    EditText nameEditText, passwordEditText;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        nameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(activity_register.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else  {
                    boolean result = db.insertUser(username, password);
                    if (result) {
                        Toast.makeText(activity_register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        finish();
                        } else {
                        Toast.makeText(activity_register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
       /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
}