package com.company.myapplication;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_feed, btn_pet, btn_clean, btn_walk, btn_sleep;
    tamagochi tamagochi1 = new tamagochi(0, 5, 0, 10);
    ProgressBar pB_hungry, pB_happy, pB_clean, pB_tired;
    TextView time, text_hungry, text_happy, text_clean, text_tired, text_time;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        btn_feed = findViewById(R.id.btn_feed);
        btn_pet = findViewById(R.id.btn_pet);
        btn_clean = findViewById(R.id.btn_clean);
        btn_walk = findViewById(R.id.btn_walk);
        btn_sleep = findViewById(R.id.btn_sleep);

        //btn_feed.setImageResource(R.mipmap.feed2);

        pB_hungry = findViewById(R.id.progressBar_hungry);
        pB_happy = findViewById(R.id.progressBar_happy);
        pB_clean = findViewById(R.id.progressBar_clean);
        pB_tired = findViewById(R.id.progressBar_tired);

        time = findViewById(R.id.time);
        text_hungry = findViewById(R.id.text_hungry);
        text_happy = findViewById(R.id.text_happy);
        text_clean = findViewById(R.id.text_clean);
        text_tired = findViewById(R.id.text_tired);


        btn_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamagochi1.feed();
                // переход на другую активность а там уже этот метод -->pB_hungry.setProgress(tamagochi1.getHungriness());
            }
        });

        btn_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamagochi1.pet();
                //аналогично pB_happy.setProgress(tamagochi1.getHappiness());

            }
        });

        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamagochi1.clean();
            }
        });

        btn_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamagochi1.walk();
            }
        });

        btn_sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tamagochi1.sleep();
            }
        });

    }


    public void Feed(View view) {
        tamagochi1.feed();
        pB_happy.setProgress(tamagochi1.getHappiness());
    }

    /*

    public void Pet(View view) {
        tamagochi1.pet();
    }

    public void Clean(View view) {
        tamagochi1.clean();
    }

    public void Walk(View view) {
    tamagochi1.walk();
    }

    public void Sleep(View view) {
    tamagochi1.sleep();
    }

    public void setFontTextView(Context context, TextView text_time) {
        Typeface font = Typeface.createFromAsset(c.getAssets(), "fonts/Arial.ttf");
        text_time.setTypeface(font);
    }

*/
}
