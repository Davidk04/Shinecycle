package com.example.shinesensor.model;

import android.widget.Button;

public class InputModel {
    Button morningButton;
    int hour, minute;
    Button nightButton;
    Button enterButton;

    public InputModel(Button morningButton, int hour, int minute, Button nightButton, Button enterButton) {
        this.morningButton = morningButton;
        this.hour = hour;
        this.minute = minute;
        this.nightButton = nightButton;
        this.enterButton = enterButton;
    }

    public Button getMorningButton() {
        return morningButton;
    }

    public void setMorningButton(Button morningButton) {
        this.morningButton = morningButton;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Button getNightButton() {
        return nightButton;
    }

    public void setNightButton(Button nightButton) {
        this.nightButton = nightButton;
    }

    public Button getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(Button enterButton) {
        this.enterButton = enterButton;
    }
}
