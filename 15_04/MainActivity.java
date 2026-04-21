package com.example.a15_04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText imie,mail;
    int counter = 0;
    TextView txt1,txt2;

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

        btn = findViewById(R.id.button);
        imie = findViewById(R.id.imie_input);
        mail = findViewById(R.id.email_input);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0);
            txt1.setText(savedInstanceState.getString("txt1", ""));
            txt2.setText(savedInstanceState.getString("txt2", "Kliknąłeś przycisk 0 razy"));
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie_s = imie.getText().toString();
                String mail_s = mail.getText().toString();
                if(imie_s.isBlank() || mail_s.isBlank())
                {
                    Toast.makeText(MainActivity.this,"Najpierw uzupełnij swoje dane", Toast.LENGTH_SHORT).show();
                }
                else{
                    counter++;
                    txt2.setText("Kliknąłeś przycisk "+counter+" razy");
                    txt1.setText("Witaj, "+imie_s+"! Twój adres e-mail to: "+mail_s);
                }
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        outState.putString("txt1", txt1.getText().toString());
        outState.putString("txt2", txt2.getText().toString());
    }
}