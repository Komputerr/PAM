package com.example.a14_01;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editTextEmail,editTextPassword,editTextPassword2;
    TextView textDisplay;
    Intent loggedIn;
    Bundle logParams;

    public void errText(String message) {
        textDisplay.setTextColor(Color.parseColor("#FF0000"));
        textDisplay.setText(message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPassword2 = findViewById(R.id.editTextPassword2);
        button = findViewById(R.id.button);
        textDisplay = findViewById(R.id.textView);
        loggedIn = new Intent(this, MainActivity2.class);
        logParams = new Bundle();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String pass1 = editTextPassword.getText().toString();
                String pass2 = editTextPassword2.getText().toString();

                if(email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                    logParams.putString("email", email);
                    loggedIn.putExtras(logParams);
                    if (pass1.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                        if (pass1.equals(pass2)) {
                            startActivity(loggedIn);
                        } else {
                            errText("Hasła się różnią");
                        }
                    } else {
                        errText("Hasła nie spełniają kryteriów");
                    }
                }
                else{
                    errText("Nieprawidłowy adres email");
                }
            }
        });
    }
}