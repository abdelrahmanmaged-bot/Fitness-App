package com.example.fitnessapp;

import android.app.Application;

public class User {
    private String name;
    private String password;
    private boolean gender;
    private int age;
    private float currentWeight;
    private float goalWeight;
    private float height;
    private String activityLevel;

    public User(String name, String password, boolean gender, int age, float currentWeight, float goalWeight, float height, String activityLevel) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.height = height;
        this.activityLevel = activityLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public float getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(float goalWeight) {
        this.goalWeight = goalWeight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
}
