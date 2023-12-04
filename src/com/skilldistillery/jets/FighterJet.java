package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

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

	@Override
	public void loadArmament() {
		// TODO Auto-generated method stub
		System.out.println(
				"Loading armament..." + "\n" + armamentQuantity + " " + armamentType + " loaded and mission ready!");
		fight();
	}

	@Override
	public void fight() {
		System.out.println("All pre-flight checks completed and ready to fight!");
		System.out.println("    \\    /\n"
				+ "_____-/\\-_____\n"
				+ "    \\_\\/_/");
	}

}
