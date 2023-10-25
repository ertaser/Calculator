package ru.appline.logic;

public class Calculator {
    private double a;
    private double b;
    private String math;
    private double c;

    public Calculator(double a, double b, String math) {
        this.a = a;
        this.b = b;
        this.math = math;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double calculate (){
        switch (math) {
            case "+": c = a + b;
                break;
            case "-": c = a - b;
                break;
            case "*": c = a * b;
                break;
            case "/": c = a / b;
                break;
        }
        return c;
    }
}
