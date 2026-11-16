package com.example.egzamin_suwaki_06_25;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    View kolor;
    TextView txtKolorZapis,txtRVal,txtGVal,txtBVal;
    SeekBar seekBarR,seekBarG,seekBarB;
    Button btnPobierz;

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
        kolor = findViewById(R.id.kolor);
        txtKolorZapis = findViewById(R.id.txtKolorZapis);
        txtRVal = findViewById(R.id.txtRVal);
        txtGVal = findViewById(R.id.txtGVal);
        txtBVal = findViewById(R.id.txtBVal);
        seekBarR = findViewById(R.id.seekBarR);
        seekBarG = findViewById(R.id.seekBarG);
        seekBarB = findViewById(R.id.seekBarB);
        btnPobierz = findViewById(R.id.btnPobierz);

        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int rn = seekBarR.getProgress();
                int gn = seekBarG.getProgress();
                int bn = seekBarB.getProgress();
                txtRVal.setText(String.valueOf(rn));
                txtGVal.setText(String.valueOf(gn));
                txtBVal.setText(String.valueOf(bn));
                kolor.setBackgroundColor(Color.rgb(rn, gn, bn));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int rn = seekBarR.getProgress();
                int gn = seekBarG.getProgress();
                int bn = seekBarB.getProgress();
                txtRVal.setText(String.valueOf(rn));
                txtGVal.setText(String.valueOf(gn));
                txtBVal.setText(String.valueOf(bn));
                kolor.setBackgroundColor(Color.rgb(rn, gn, bn));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int rn = seekBarR.getProgress();
                int gn = seekBarG.getProgress();
                int bn = seekBarB.getProgress();
                txtRVal.setText(String.valueOf(rn));
                txtGVal.setText(String.valueOf(gn));
                txtBVal.setText(String.valueOf(bn));
                kolor.setBackgroundColor(Color.rgb(rn, gn, bn));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnPobierz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rn = seekBarR.getProgress();
                int gn = seekBarG.getProgress();
                int bn = seekBarB.getProgress();
                txtKolorZapis.setBackgroundColor(Color.rgb(rn, gn, bn));
                txtKolorZapis.setText(String.format("%d, %d, %d", rn, gn, bn));
            }
        });
    }
}