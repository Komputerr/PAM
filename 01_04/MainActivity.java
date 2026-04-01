package edu.zsk.a01_04;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Intent secondActiv;
    Intent thirdActiv;
    Button button1,button2;
    NotificationManager notificationManager;

    String CHANNEL_ID = "channel_high";
    String CHANNEL_NAME = "channel_low";

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
        secondActiv = new Intent(MainActivity.this,MainActivity2.class);
        thirdActiv = new Intent(MainActivity.this,MainActivity3.class);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, secondActiv,
                                PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_HIGH);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
                Notification notification =
                        new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                .setSmallIcon(android.R.drawable.ic_dialog_info)
                                .setContentTitle("Powiadomienie high")
                                .setContentText("powiadomienie najwyższego priorytetu")
                                .setContentIntent(pendingIntent)
                                .build();
                int id = 1;
                notificationManager.notify(id, notification);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, thirdActiv,
                                PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_LOW);
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
                Notification notification =
                        new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                .setSmallIcon(android.R.drawable.ic_dialog_info)
                                .setContentTitle("Powiadomienie low")
                                .setContentText("powiadomienie najniższego priorytetu")
                                .setContentIntent(pendingIntent)
                                .build();
                int id = 1;
                notificationManager.notify(id, notification);
            }
        });
    }
}