package com.example.a26_11;

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

        EditText editText2 = findViewById(R.id.editTextText2);
        Button bt1 = findViewById(R.id.button);
        Button bt2 = findViewById(R.id.button2);


        bt2.setOnClickListener(v ->
        {
            CharSequence text = editText2.getText().toString();
            Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
            toast.show();
        });
    }
    public void InputText(View view)
    {
        EditText editText1 = findViewById(R.id.editTextText);
        TextView textView = findViewById(R.id.textView);
        CharSequence text = editText1.getText().toString();
        textView.setText(text);
    }



}