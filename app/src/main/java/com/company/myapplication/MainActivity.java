package com.company.myapplication;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    Chronometer mChronometer;
    ImageButton btn_feed, btn_pet, btn_clean, btn_walk, btn_sleep;
    tamagochi tamagochi1 = new tamagochi(5, 5, 5, 5);
    ProgressBar pB_hungry, pB_happy, pB_clean, pB_tired;
    TextView text_hungry, text_happy, text_clean, text_tired, text_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mChronometer = findViewById(R.id.chronos);
        mChronometer.setCountDown(false);
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

                long elapsedMillis = mChronometer.getBase();
                tamagochi1.passTime();
                pB_hungry.setProgress(tamagochi1.getHungriness());
                pB_happy.setProgress(tamagochi1.getHappiness());
                pB_clean.setProgress(tamagochi1.getCleanliness());
                pB_tired.setProgress(tamagochi1.getStrength());
            }

        });


        btn_feed = findViewById(R.id.btn_feed);
        btn_pet = findViewById(R.id.btn_pet);
        btn_clean = findViewById(R.id.btn_clean);
        btn_walk = findViewById(R.id.btn_walk);
        btn_sleep = findViewById(R.id.btn_sleep);

        pB_hungry = findViewById(R.id.progressBar_hungry);
        pB_happy = findViewById(R.id.progressBar_happy);
        pB_clean = findViewById(R.id.progressBar_clean);
        pB_tired = findViewById(R.id.progressBar_tired);

        pB_hungry.setProgress(tamagochi1.getHungriness());
        pB_happy.setProgress(tamagochi1.getHappiness());
        pB_clean.setProgress(tamagochi1.getCleanliness());
        pB_tired.setProgress(tamagochi1.getStrength());

        text_hungry = findViewById(R.id.text_hungry);
        text_happy = findViewById(R.id.text_happy);
        text_clean = findViewById(R.id.text_clean);
        text_tired = findViewById(R.id.text_tired);


    }

   /*
    пока рано, когда с кнопками разберемся таймер поставим на них. // todo переделать разметку фрагментами, вставить background, вставить срайты девочки(может не прокатить, поэтому сначала попробовать это), дописать методы на кнопки
    public void onStartClick(View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
    }

    public void onStopClick(View view) {
        mChronometer.stop();
    }

    public void onResetClick(View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
    }
    */

    public void Feed(View view) {
        tamagochi1.feed();
        pB_hungry.setProgress(tamagochi1.getHungriness());
        pB_happy.setProgress(tamagochi1.getHappiness());
        pB_tired.setProgress(tamagochi1.getStrength());
    }

    public void Pet(View view) {
        tamagochi1.pet();
        pB_happy.setProgress(tamagochi1.getHappiness());
    }

    public void Clean(View view) {
        tamagochi1.clean();
        pB_clean.setProgress(tamagochi1.getCleanliness());
    }

    public void Walk(View view) {
        tamagochi1.walk();
        pB_tired.setProgress(tamagochi1.getStrength());
        pB_happy.setProgress(tamagochi1.getHappiness());
        pB_clean.setProgress(tamagochi1.getCleanliness());

    }

    public void Sleep(View view) {
        tamagochi1.sleep();
        pB_tired.setProgress(tamagochi1.getStrength());
    }
}
