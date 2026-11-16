package com.example.egzamin_hasla;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String haslo = "";
    String abc = "abcdefghijklmnopqrstuwxyz";
    String abcB = "ABCDEFGHIJKLMNOPQRSTUWXYZ";
    String spec = "!@#$%^&*()_+-=";
    Button btnGeneruj,btnZatwierdz;
    Spinner spinner;
    EditText txtZnaki, txtImie, txtNazwisko;
    CheckBox cbLitery,cbCyfry,cbSpecjalne;
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
        spinner = findViewById(R.id.spinner);
        String[] stanowisko = getResources().getStringArray(R.array.stanowisko);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stanowisko);
        spinner.setAdapter(arrayAdapter);
        btnGeneruj = findViewById(R.id.btnHaslo);
        btnZatwierdz = findViewById(R.id.btnZatwierdz);
        txtZnaki = findViewById(R.id.txtZnaki);
        cbLitery = findViewById(R.id.cbLitery);
        cbCyfry = findViewById(R.id.cbCyfry);
        cbSpecjalne = findViewById(R.id.cbSpecjalne);
        txtImie = findViewById(R.id.txtImie);
        txtNazwisko = findViewById(R.id.txtNazwisko);

        btnGeneruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haslo="";
                Random random = new Random();
                int znaki = Integer.parseInt(txtZnaki.getText().toString());
                if(cbLitery.isChecked())
                {
                    int rand = random.nextInt(abcB.length());
                    haslo += abcB.charAt(rand);
                    znaki--;
                }
                if(cbCyfry.isChecked())
                {
                    int rand = random.nextInt(10);
                    haslo += rand;
                    znaki--;
                }
                if(cbSpecjalne.isChecked())
                {
                    int rand = random.nextInt(spec.length());
                    haslo += spec.charAt(rand);
                    znaki--;
                }
                for (int i=0;i<znaki;i++)
                {
                    int rand = random.nextInt(abc.length());
                    haslo += abc.charAt(rand);
                }
                new AlertDialog.Builder(MainActivity.this).setMessage(haslo).setPositiveButton("OK", null).show();
            }

        });
        btnZatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setMessage("Dane pracownika: " +txtImie.getText()+" "+txtNazwisko.getText()+" "+spinner.getSelectedItem().toString()+" Hasło: "+haslo).setPositiveButton("OK", null).show();
            }
        });
    }
}