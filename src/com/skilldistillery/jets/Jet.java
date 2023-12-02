package com.skilldistillery.jets;

public abstract class Jet {

	private String model;
	private double speedInMph;
	private int range;
	private long purchasePrice;

	public Jet() {

	}

	public Jet(String model, double speedInMph, int range, long purchasePrice) {
		super();
		this.model = model;
		this.speedInMph = speedInMph;
		this.range = range;
		this.purchasePrice = purchasePrice;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeedInMph() {
		return speedInMph;
	}

	public void setSpeedInMph(int speedInMph) {
		this.speedInMph = speedInMph;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public abstract void fly();

	@Override
	public String toString() {
		return "Jet Information\nModel: " + model + "\nSpeed In MPG: " + speedInMph + " MPH" + "\nRange: " + range
				+ "\nPurchase Price: $" + purchasePrice;
	}

}
