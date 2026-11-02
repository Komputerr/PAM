package com.example.a26_10_2026;

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
    Button btnZaszyfruj;
    TextView txtZaszyfrowany;
    EditText txtTekst,txtKlucz;
    private static final int ALPHABET_LENGTH = 26;
    public static String encrypt(String text, int key)
    {
        int shift = key % ALPHABET_LENGTH;
        if (shift < 0) {
            shift = shift + ALPHABET_LENGTH;
        }
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int position = c - 'a';
                int newPosition = (position + shift) % ALPHABET_LENGTH;
                char newLetter = (char) ('a' + newPosition);
                result.append(newLetter);
            } else {
                result.append(c);
            }
        }
        return result.toString();
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
        btnZaszyfruj = findViewById(R.id.btnZaszyfruj);
        txtZaszyfrowany = findViewById(R.id.txtZaszyfrowany);
        txtTekst = findViewById(R.id.txtTekst);
        txtKlucz = findViewById(R.id.txtKlucz);
        btnZaszyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txtTekst.getText().toString();
                String keyStr = txtKlucz.getText().toString();
                int key =0;
                if (!keyStr.isEmpty()) {
                    key = Integer.parseInt(keyStr);
                }
                String cezar = encrypt(text,key);
                txtZaszyfrowany.setText(cezar);
            }
        });
    }
}