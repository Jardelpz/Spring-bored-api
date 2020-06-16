package com.example.demo.hello;

public class HelloSpring {
    String message;

    public HelloSpring(String m){
        this.message = m;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}