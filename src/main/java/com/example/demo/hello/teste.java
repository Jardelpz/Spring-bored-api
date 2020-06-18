package com.example.demo.hello;

import java.util.Calendar;

import com.example.demo.BoredController;

public class teste {
    public static void main(String[] args){
        Calendar data = Calendar.getInstance();
        int h =(data.get(Calendar.HOUR_OF_DAY)); 
        BoredController b = new BoredController();
        System.out.print(b.discoverHour(h));
    }
}