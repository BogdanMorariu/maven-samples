package com.bm;

import com.bm.Model.*;

/**
 * Created by Bogdan on 03.10.2017.
 */
class Calculator {

    public double calculate(Double double1, Double double2, String sign){
        Operator operator = null;
        switch (sign){
            case "+": {
                operator = new Plus();
                break;
            }
            case "-": {
                operator = new Minus();
                break;
            }
            case "*": {
                operator = new Multiply();
                break;
            }
            case "/": {
                operator = new Divide();
                break;
            }
            default : throw new RuntimeException("Invalid Sign !");
        }
        return operator.execute(double1,double2);
    }
}
