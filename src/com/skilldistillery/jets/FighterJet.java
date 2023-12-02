package com.skilldistillery.jets;

public class FighterJet extends Jet {

	private int armamentQuantity;
	private String armamentType;

	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speedInMph, int range, long purchasePrice, int armamentQuantity,
			String armamentType) {
		super(model, speedInMph, range, purchasePrice);
		this.armamentQuantity = armamentQuantity;
		this.armamentType = armamentType;
	}

	public int getArmamentQuantity() {
		return armamentQuantity;
	}

	public void setArmamentQuantity(int armamentQuantity) {
		this.armamentQuantity = armamentQuantity;
	}

	public String getArmamentType() {
		return armamentType;
	}

	public void setArmamentType(String armamentType) {
		this.armamentType = armamentType;
	}

	@Override
	public void fly() {
		double flightTime = getRange() / getSpeedInMph();
		System.out.println(toString() + "\nTheoretical Flight Time: " + flightTime);
	}

	@Override
	public String toString() {
		return "Fighter Jet Information\nModel: " + getModel() + "\nSpeed In Mph: " + getSpeedInMph() + "\nRange: "
				+ getRange() + "\nPurchase Price: $" + getPurchasePrice() + "\nArmament: " + armamentQuantity + " "
				+ armamentType;
	}

}
