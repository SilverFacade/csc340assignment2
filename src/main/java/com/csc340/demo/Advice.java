package com.csc340.demo;

public class Advice {

    public String advice;
    public int id;

    public Advice(String advice, int id) {
        this.advice = advice;
        this.id = id;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getAdvice() {return advice;}

    public void setAdvice(String advice) {this.advice = advice;}

}
