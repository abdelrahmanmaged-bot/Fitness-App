package com.example.fitnessapp;

public class BMI_Calculator {
    private float height;
    private float weight;

    public BMI_Calculator(float height, float weight) {
        this.height =0;
        this.weight =0;
    }

   /* public float getHeight() {
        return height;
    }*/

    public void setHeight(float height) {
        this.height = height;
    }

   /* public float getWeight() {
        return weight;
    }*/

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float bmi_calculator() {
        return (weight/(height*height));
    }
}
