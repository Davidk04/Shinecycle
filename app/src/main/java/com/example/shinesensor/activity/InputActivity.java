package com.example.shinesensor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.shinesensor.R;
import com.example.shinesensor.service.AlertService;
import com.example.shinesensor.service.LightSensorService;

import java.util.Calendar;
import java.util.Locale;

public class InputActivity extends AppCompatActivity {
    Button morningButton;
    int hourMorning, minuteMorning, hourNight, minuteNight;
    Button nightButton;
    Button enterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        morningButton = findViewById(R.id.morningButton);
        nightButton = findViewById(R.id.nightButton);
        enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity();
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onClickMorningButton(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectHour, int selectMinute) {
                hourMorning = selectHour;
                minuteMorning = selectMinute;
                morningButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hourMorning, minuteMorning));
            }
        };
        TimePickerDialog timePickerDialogMorning = new TimePickerDialog(this, onTimeSetListener, hourMorning, minuteMorning, true);
        timePickerDialogMorning.show();

    }

    public void onClickNightButton(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectHour, int selectMinute) {
                hourNight = selectHour;
                minuteNight = selectMinute;
                nightButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hourNight, minuteNight));
            }
        };
        TimePickerDialog timePickerDialogNight = new TimePickerDialog(this, onTimeSetListener, hourNight, minuteNight, true);
        timePickerDialogNight.show();
    }
    public void openActivity(){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("hourMorning", hourMorning);
        intent.putExtra("hourNight", hourNight);
        intent.putExtra("minuteMorning", minuteMorning);
        intent.putExtra("minuteNight", minuteNight);
        startActivity(intent);
    }
}