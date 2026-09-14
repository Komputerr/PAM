package com.example.a14_09_2026;

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

    EditText numPrania;
    Button zatwierdz,wlacz;
    TextView txtNumerPrania,txtOdkurzacz,txtOdkurzaczStan;

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

        numPrania = findViewById(R.id.numPrania);
        zatwierdz = findViewById(R.id.btnZatwierdz);
        wlacz = findViewById(R.id.btnWlacz);
        txtNumerPrania = findViewById(R.id.txtNrPrania);
        txtOdkurzacz = findViewById(R.id.odkurzaczWlaczony);
        txtOdkurzaczStan = findViewById(R.id.odkurzaczStatus);

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numerPrania = Integer.parseInt(numPrania.getText().toString());
                if(numerPrania >=1 && numerPrania <=12)
                {
                    txtNumerPrania.setText("Numer prania: " + numerPrania);
                }
            }
        });
        wlacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wlacz.getText().toString().equals("Włącz"))
                {
                    wlacz.setText("Wyłącz");
                    txtOdkurzacz.setText("Odkurzacz włączony");
                }
                else{
                    wlacz.setText("Włącz");
                    txtOdkurzacz.setText("Odkurzacz wyłączony");
                }
            }
        });
    }
}