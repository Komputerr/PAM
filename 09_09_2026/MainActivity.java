package com.example.egzamin_24_06_2024;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRzut,btnResetuj;
    ImageView zdj1,zdj2,zdj3,zdj4,zdj5;
    TextView gra,losowanie;
    int wynikGry = 0;

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

        btnRzut = findViewById(R.id.btnRzuc);
        btnResetuj = findViewById(R.id.btnReset);
        zdj1 = findViewById(R.id.img1);
        zdj2 = findViewById(R.id.img2);
        zdj3 = findViewById(R.id.img3);
        zdj4 = findViewById(R.id.img4);
        zdj5 = findViewById(R.id.img5);
        losowanie = findViewById(R.id.wynikLos);
        gra = findViewById(R.id.wynikGry);

        ImageView[] zdjecia ={
                zdj1,
                zdj2,
                zdj3,
                zdj4,
                zdj5
        };

        int[] kostki = {
                R.drawable.k1,
                R.drawable.k2,
                R.drawable.k3,
                R.drawable.k4,
                R.drawable.k5,
                R.drawable.k6
        };

        Random random = new Random();


        btnRzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wynikLos = 0;
                for (int i=0;i<5;i++)
                {
                    int wylosowanaLiczba = random.nextInt(6) + 1;
                    zdjecia[i].setImageResource(kostki[wylosowanaLiczba-1]);
                    wynikLos += wylosowanaLiczba;
                    losowanie.setText("Wynik tego losowania: "+wynikLos);
                    wynikGry += wylosowanaLiczba;
                    gra.setText("Wynik gry: "+ wynikGry);
                }
            }
        });
        btnResetuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++)
                {
                    zdjecia[i].setImageResource(R.drawable.question);
                    losowanie.setText("Wynik tego losowania: ");
                    wynikGry = 0;
                    gra.setText("Wynik gry: ");
                }
            }
        });
    }
}