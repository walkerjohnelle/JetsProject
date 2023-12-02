package com.skilldistillery.jets;

public class CargoPlane extends Jet {

	private double cargoCapacityInLbs;
	private double actualCargoWeightInLbs;

	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speedInMph, int range, long purchasePrice, double cargoCapacityInLbs,
			double actualCargoWeightInLbs) {

		super(model, speedInMph, range, purchasePrice);
		this.cargoCapacityInLbs = cargoCapacityInLbs;
		this.actualCargoWeightInLbs = actualCargoWeightInLbs;
	}

	public double getCargoCapacityInLbs() {
		return cargoCapacityInLbs;
	}

	public void setCargoCapacityInLbs(double cargoCapacityInLbs) {
		this.cargoCapacityInLbs = cargoCapacityInLbs;
	}

	public double getActualCargoWeightInLbs() {
		return actualCargoWeightInLbs;
	}

	public void setActualCargoWeightInLbs(double actualCargoWeightInLbs) {
		this.actualCargoWeightInLbs = actualCargoWeightInLbs;
	}

	@Override
	public void fly() {
		double flightTime = getRange() / getSpeedInMph();
		double adjustedFlightTime = flightTime * (1 - actualCargoWeightInLbs / cargoCapacityInLbs);

		System.out.println(toString() + "\nTheoretical Flight Time With Cargo: " + adjustedFlightTime);
	}

	@Override
	public String toString() {
		return "Fighter Jet Information\nModel: " + getModel() + "\nSpeed In Mph: " + getSpeedInMph() + "\nRange: "
				+ getRange() + "\nPurchase Price: $" + getPurchasePrice() + "\nCargo Capactity: " + cargoCapacityInLbs
				+ "lbs" + "\nActual Cargo Weight: " + actualCargoWeightInLbs + "lbs";
	}
}
