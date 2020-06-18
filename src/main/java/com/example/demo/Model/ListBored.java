package com.example.demo.Model;

import java.util.ArrayList;

public class ListBored {
    ArrayList<Bored> boreds = new ArrayList<>();

    public void addBored(Bored e){
        this.boreds.add(e);
    }

    public ArrayList<Bored> getBoreds() {
		return boreds;
	}

	public void setBoreds(ArrayList<Bored> boreds) {
		this.boreds = boreds;
	}
}