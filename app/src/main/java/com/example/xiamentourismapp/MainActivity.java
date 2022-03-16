package com.example.xiamentourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int loading_time = 3000;
    Animation animation1, animation2;
    TextView tvApp;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // make this activity a splash screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // link anim file with java
        animation1 = AnimationUtils.loadAnimation(this, R.anim.animation_splash);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.animation_logo);
        // Hook animation widget
        tvApp = findViewById(R.id.tv_appName);
        logo = findViewById(R.id.app_logo);
        // start animation
        tvApp.setAnimation(animation1);
        logo.setAnimation(animation2);

        // Handler to run splash screen and direct to the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                finish();
            }
        },loading_time);
    }
}