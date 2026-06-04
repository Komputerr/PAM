package com.example.a29_04;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.image_container);

        for (int i = 0; i < container.getChildCount(); i++) {
            final int index = i + 1;
            ImageView iv = (ImageView) container.getChildAt(i);
            final int resId = getResources().getIdentifier("img" + index, "drawable", getPackageName());
            iv.setOnClickListener(v ->
                    PhotoDialogFragment.newInstance(resId)
                            .show(getSupportFragmentManager(), "photo")
            );
        }
    }
}