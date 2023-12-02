package com.skilldistillery.jets;

public class PassengerJet extends Jet {

	private int passengerCapacity;
	private int totalPassengers;

	public PassengerJet() {
		super();

	}

	public PassengerJet(String model, double speedInMph, int range, long purchasePrice, int passengerCapacity,
			int totalPassengers) {

		super(model, speedInMph, range, purchasePrice);
		this.passengerCapacity = passengerCapacity;
		this.totalPassengers = totalPassengers;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public int getTotalPassengers() {
		return totalPassengers;
	}

	public void setTotalPassengers(int totalPassengers) {
		this.totalPassengers = totalPassengers;
	}

	@Override
	public void fly() {
		double flightTime = getRange() / getSpeedInMph();
		System.out.println(toString() + "\nTheoretical Flight Time: " + flightTime);
	}

	@Override
	public String toString() {
		return "Passenger Jet Information\nModel: " + getModel() + "\nSpeed In Mph: " + getSpeedInMph() + "\nRange: "
				+ getRange() + "\nPurchase Price: $" + getPurchasePrice() + "\nPassenger Capacity: " + passengerCapacity
				+ "\nTotal Passengers: " + totalPassengers;
	}

}
