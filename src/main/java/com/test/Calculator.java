package com.test;

/**
 * Created by raul on 3/30/17.
 */
public class Calculator implements CalculatorInterface{
    protected int num1;
    protected int num2;

    Calculator(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public int add(){
        return num1+num2;
    }
    public int subtract(){return num1-num2;}
    public int subtractNums(int num1, int num2){return num1-num2;}
    public int addNums(int num1, int num2){return num1+num2;}
}
