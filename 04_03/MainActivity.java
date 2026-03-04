package com.example.a04_03;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText input_name,input_surname,input_class_name;
    Intent intent;
    Bundle bundle;

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

        btn = findViewById(R.id.save_note_button);
        input_name = findViewById(R.id.name_input);
        input_surname = findViewById(R.id.surname_input);
        input_class_name = findViewById(R.id.class_input);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input_name.getText().toString();
                String surname = input_surname.getText().toString();
                String class_name = input_class_name.getText().toString();

                if(name.isBlank() || surname.isBlank() || class_name.isBlank())
                {
                    Toast.makeText(MainActivity.this,"Wypełnij wszystkie pola!",Toast.LENGTH_SHORT).show();
                }
                else{
                    intent = new Intent(MainActivity.this,ReportedActivity.class);
                    ProgressDialog progress = new ProgressDialog(MainActivity.this);
                    progress.setTitle("Dodaj uwagę...");
                    progress.setMessage("Proszę czekać");
                    progress.show();
                    bundle = new Bundle();
                    bundle.putString("name",name);
                    bundle.putString("surname",surname);
                    bundle.putString("class_name",class_name);

                }
            }
        });
    }
}