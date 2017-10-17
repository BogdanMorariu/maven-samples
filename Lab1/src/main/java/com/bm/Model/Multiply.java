package com.bm.Model;

public class Multiply implements Operator {
    @Override
    public Double execute(Double double1, Double double2) {
        return double1 * double2;
    }
}
