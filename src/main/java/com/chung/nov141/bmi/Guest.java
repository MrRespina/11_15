package com.chung.nov141.bmi;

// javaBean : data 한번에 포장해서 넘기기 편함

public class Guest {
	private String name;
	private double height;
	private double weight;
	private double bmi;
	private String result;
	private String image;
	// constructor(생성자) : ctrl + space + enter
	public Guest() {
		// TODO Auto-generated constructor stub
	}
	// constructor overloading(생성자오버로딩) : ctrl + shift + a
	public Guest(String name, double height, double weight, double bmi, String result, String image) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.result = result;
		this.image = image;
	}
	// getters and setters : ctrl + shift + z
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
