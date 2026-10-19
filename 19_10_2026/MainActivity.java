package com.example.a19_10_2026;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    Button btnOk;
    SeekBar sbWiek;
    int index=0;
    TextView txtLata,txtDane,txtCel,txtWynik,txtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtTIme), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtTime = findViewById(R.id.txtTime);
        txtWynik = findViewById(R.id.txtWynik);
        txtCel = findViewById(R.id.txtCel);
        txtDane = findViewById(R.id.txtDane);
        txtLata = findViewById(R.id.txtLat);
        sbWiek = findViewById(R.id.seekBarLat);
        btnOk = findViewById(R.id.btnOk);
        lista = findViewById(R.id.listGatunek);
        String[] gatunki = getResources().getStringArray(R.array.gatunek);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gatunki);
        lista.setAdapter(arrayAdapter);

        sbWiek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtLata.setText("Ile masz lat? " +progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        sbWiek.setMax(18);
                        index=0;
                        break;
                    case 1:
                        sbWiek.setMax(20);
                        index=1;
                        break;
                    case 2:
                        sbWiek.setMax(9);
                        index=2;
                        break;
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtWynik.setText(txtDane.getText()+", "+gatunki[index]+", "+sbWiek.getProgress()+", "+txtCel.getText()+", "+txtTime.getText());
            }
        });
    }
}