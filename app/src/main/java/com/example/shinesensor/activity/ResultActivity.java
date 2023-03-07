package com.example.shinesensor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.shinesensor.R;

import java.util.Calendar;

public class ResultActivity extends AppCompatActivity {
    Boolean isNight;
    TextView title;
    TextView recomendedLux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        title = findViewById(R.id.title);
        recomendedLux = findViewById(R.id.recomendedLux);
        setTitles();
    }

    public void getTime(){
        //Code from StackOverflow: https://stackoverflow.com/questions/8250367/android-detect-if-night
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if(hour < 6 || hour > 18){
            isNight = true;
        } else {
            isNight = false;
        }
    }

    public void setTitles(){
        getTime();
        if (isNight){
            title.setText("good evening");
            recomendedLux.setText("200 lux");

        }else{
            title.setText("good morning");
            recomendedLux.setText("400 lux");
        }
    }
}