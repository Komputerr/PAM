package com.example.a14_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView editTextEmail;
    Button button;
    Intent loginActyivity;
    Intent emailBundle;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextEmail = findViewById(R.id.textEmail);
        button = findViewById(R.id.button2);
        emailBundle = getIntent();
        loginActyivity = new Intent(this, MainActivity.class);
        email = emailBundle.getStringExtra("email");

        if(email==null)
        {
            email = "testemail@gmail.com";
        }
        editTextEmail.setText("Zalogowano jako " + email);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(loginActyivity);
                finish();
            }
        });
    }
}