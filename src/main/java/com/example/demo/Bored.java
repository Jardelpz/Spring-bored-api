package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bored {
	private String activity;
	private String type;
    private int participants;
    private double price;
    private String link;
    private int key;
    private double acessibility;
    
    
	public Bored(String type){
		// String activity, String type, int participants, double price, String link, int key, double acessibility) {
		// super();
		// this.activity = activity;
		this.type = type;
		// this.participants = participants;
		// this.price = price;
		// this.link = link;
		// this.key = key;
		// this.acessibility = acessibility;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public double getAcessibility() {
		return acessibility;
	}
	public void setAcessibility(double acessibility) {
		this.acessibility = acessibility;
	}
}