package com.example.shinesensor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.shinesensor.R;
import com.example.shinesensor.service.AlertService;
import com.example.shinesensor.service.LightSensorService;

import java.util.Calendar;

public class ResultActivity extends AppCompatActivity {
    Boolean isNight;
    TextView title;
    TextView recomendedLux;
    TextView currentLux;
    float receivedLux;
    Bundle scheduleTime;

    int hourMorning;
    int hourNight;
    int minuteMorning;
    int minuteNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        title = findViewById(R.id.title);
        recomendedLux = findViewById(R.id.recomendedLux);
        currentLux = findViewById(R.id.currentLux);
        setTitles();
        lightSensorService();
        getSchedule();
        currentLux.setText(String.valueOf(receivedLux) + " lux");
            if(!isNight && receivedLux < 400) {
                Intent intent = new Intent(this, AlertService.class);
                intent.putExtra("title", "Turn the light up");
                startService(intent);
            }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, InputActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void getTime() {
        //Code from StackOverflow: https://stackoverflow.com/questions/8250367/android-detect-if-night
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour < 6 || hour > 18) {
            isNight = true;
        } else {
            isNight = false;
        }
    }

    public void setTitles() {
        getTime();
        if (isNight) {
            title.setText("good evening");
            recomendedLux.setText("200 lux");

        } else {
            title.setText("good morning");
            recomendedLux.setText("400 lux");
        }
    }

    public void lightSensorService(){
        Intent intent = new Intent(this, LightSensorService.class);
        startService(intent);
        Intent data = getIntent();
        receivedLux = data.getFloatExtra("lux", 0);
    }

    public void getSchedule(){
        Intent intent = new Intent(this, InputActivity.class);
        startService(intent);
        Intent schedule = getIntent();
        scheduleTime = schedule.getExtras();
        System.out.println(scheduleTime);

    }
}