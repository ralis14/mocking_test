package com.test;

/**
 * Created by raul on 4/2/17.
 */

//This is the mathservice actual class, it takes a Calculator object in its contructor
    //add method calls the calculator object and does the adding then it returns the result from the calculator object
public class MathService {
    protected Calculator calculator;

    MathService(Calculator calculator){
        this.calculator = calculator;

    }
    public int add(int a, int b){
        int result = calculator.addNums(a, b);
        return result;
    }
}
