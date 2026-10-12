package com.example.a05_10_2026;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPolub, btnUsun;
    TextView txtPolubien;
    int polubienia = 0;

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
        btnPolub = findViewById(R.id.btnPolub);
        btnUsun = findViewById(R.id.btnUsun);
        txtPolubien = findViewById(R.id.txtPolubienia);

        btnPolub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                polubienia++;
                txtPolubien.setText(polubienia + " polubień");
            }
        });
        btnUsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                polubienia--;
                if(polubienia<0)
                {
                    polubienia=0;
                }
                txtPolubien.setText(polubienia + " polubień");
            }
        });
    }
}