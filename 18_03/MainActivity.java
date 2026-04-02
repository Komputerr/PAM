package com.example.a18_03;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SeekBar slider;
    ListView list;
    TextView lata;
    Button btn;
    EditText imie,cel,czas;

    String CHANNEL_ID = "channel_high";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        slider = findViewById(R.id.seekBar);
        list = findViewById(R.id.lista);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lata = findViewById(R.id.lata);
        btn = findViewById(R.id.btn);
        imie = findViewById(R.id.imie);
        cel = findViewById(R.id.cel);
        czas = findViewById(R.id.czas);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0: slider.setMax(18); break;
                    case 1: slider.setMax(20); break;
                    case 2: slider.setMax(9); break;
                }
            }
        });

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lata.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_imie = imie.getText().toString();
                String s_gatunek = (list.getCheckedItemPosition() >= 0) ? list.getItemAtPosition(list.getCheckedItemPosition()).toString() : "nie zaznaczono gatunku";
                String s_wiek  = lata.getText().toString();
                String s_cel = cel.getText().toString();
                String s_czas  = czas.getText().toString();

                String message = s_imie+", "+s_gatunek+", "+s_wiek+", "+s_cel+", "+s_czas;

                NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"Weterynarz",NotificationManager.IMPORTANCE_HIGH);                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);

                Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Wizyta u weterynarza")
                        .setContentText(message)
                        .build();

                int id = 1;
                notificationManager.notify(id, notification);
            }
        });

    }
}