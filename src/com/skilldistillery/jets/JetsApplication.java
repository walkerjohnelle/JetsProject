package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Scanner;

public class JetsApplication {

	private Airfield airfield;
	private Scanner sc;

	public JetsApplication() {
		this.airfield = new Airfield();
		airfield.addJets(new FighterJet("F-35", 1200, 1200, 70_000_000, 2, "AIM-120 AMRAAM"));
		airfield.addJets(new FighterJet("A-10", 420, 2578, 18_000_000, 1350, "GAU-8A rounds"));
		airfield.addJets(new CargoPlane("C-17", 590, 2400, 370_000_000, 170_000, 29_000));
		airfield.addJets(new CargoPlane("C-130", 367, 2361, 75_000_000, 42_000, 29_000));
		airfield.addJets(new PassengerJet("C-21", 530, 2306, 3_100_000, 10, 8));
	}

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.run();
	}

	public void run() {
		sc = new Scanner(System.in);

		while (true) {
			System.out.println("************************************");
			System.out.println("\nMENU:");
			System.out.println("1. List fleet: ");
			System.out.println("2. Fly all jets: ");
			System.out.println("3. View fastest jet: ");
			System.out.println("4. View jet with the longest range: ");
			System.out.println("5. Load all Cargo Jets: ");
			System.out.println("6. Dogfight!: ");
			System.out.println("7. Add a jet to Fleet: ");
			System.out.println("8. Remove a jet from Fleet: ");
			System.out.println("9. Quit: ");
			System.out.println("*************************************");

			System.out.println("Please make a selection by choosing a number (1 - 9): ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				listFleet();
				break;
			case 2:
				flyAllJets();
				break;
			case 3:
				viewFastestJet();
				break;
			case 4:
				viewJetWithLongestRange();
				break;
			case 5:
				loadAllCargoJets();
				break;
			case 6:
				dogfight();
				break;
			case 7:
				addJet();
				break;
			case 8:
				removeJet();
				break;
			case 9:
				System.out.println("Closing app...Goodbye!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid entry! Make a selection by choosing a number (1 - 9): ");
			}
		}
	}

	private void listFleet() {
		ArrayList<Jet> jets = airfield.getJets();
		for (int i = 0; i < jets.size(); i++) {
			System.out.println((i + 1) + ". " + jets.get(i));
		}
	}

	public void flyAllJets() {
		for (Jet jet : this.airfield.getJets()) {
			jet.fly();
		}
	}

	public void viewFastestJet() {
		Jet fastestJet = airfield.getFastestJet();
		if (fastestJet != null) {
			System.out.println("Fastest Jet: " + fastestJet.toString());
		} else {
			System.out.println("Error: Finding fastest Jet");
		}
	}

	public void viewJetWithLongestRange() {
		Jet longestRangeJet = airfield.getLongestRangeJet();
		if (longestRangeJet != null) {
			System.out.println("Jet With Longest Range: " + longestRangeJet.toString());
		} else {
			System.out.println("Error: Finding Longest Ranged Jet");
		}
	}

	public void loadAllCargoJets() {
		for (Jet jet : this.airfield.getJets()) {
			if (jet instanceof CargoCarrier) {
				System.out.println("Permission to load cargo plane #" + (this.airfield.getJets().indexOf(jet) + 1));
				System.out.println(jet.toString());
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void dogfight() {
		for (Jet jet : this.airfield.getJets()) {
			if (jet instanceof CombatReady) {
				System.out.println("Permission to deploy fighter jet #" + (this.airfield.getJets().indexOf(jet) + 1));
				System.out.println(jet.toString());
				((CombatReady) jet).fight();
			}
		}
	}

	private void addJet() {
		System.out.println("Enter jet type (Fighter, Cargo, or Passenger): ");
		String jetType = sc.nextLine().toUpperCase();

		if (jetType.equals("FIGHTER")) {
			addFighterJet();
		} else if (jetType.equals("CARGO")) {
			addCargoJet();
		} else if (jetType.equals("PASSENGER")) {
			addPassengerJet();
		} else {
			System.out.println("Invalid jet type. Please choose Fighter, Cargo, or Passenger.");
		}
	}

	private void addCargoJet() {
		airfield.addJets(new CargoPlane());
		System.out.print("Enter cargo jet model: ");
		String model = sc.nextLine();
		System.out.print("Enter cargo jet speed (mph): ");
		double speed = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter cargo jet range (miles): ");
		int range = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter cargo jet price: $");
		long price = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter cargo jet capacity (lbs): ");
		int capacity = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter current cargo load (tons): ");
		int load = sc.nextInt();
		sc.nextLine();

		CargoPlane cargoJet = new CargoPlane(model, speed, range, price, capacity, load);
		airfield.addJets(cargoJet);
		System.out.println("Cargo Jet successfully added to fleet!");
	}

	private void addPassengerJet() {
		airfield.addJets(new PassengerJet());
		System.out.print("Enter passenger jet model: ");
		String model = sc.nextLine();
		System.out.print("Enter passenger jet speed (mph): ");
		double speed = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter passenger jet range (miles): ");
		int range = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter passenger jet price: $");
		long price = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter passenger jet passenger capacity: ");
		int passengerCapacity = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter total amount of passengers to fly: ");
		int totalPassengers = sc.nextInt();
		sc.nextLine();

		PassengerJet passengerJet = new PassengerJet(model, speed, range, price, passengerCapacity, totalPassengers);
		airfield.addJets(passengerJet);
		System.out.println("Passenger Jet successfully added to fleet!");
	}

	private void addFighterJet() {
		airfield.addJets(new FighterJet());
		System.out.print("Enter fighter jet model: ");
		String model = sc.nextLine();
		System.out.print("Enter fighter jet speed (mph): ");
		double speed = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter fighter jet range (miles): ");
		int range = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter fighter jet price: $");
		long price = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter fighter jet armament quantity: ");
		int armamentQuantity = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter total amount of passengers to fly: ");
		String armamentType = sc.nextLine();

		FighterJet fighterJet = new FighterJet(model, speed, range, price, armamentQuantity, armamentType);
		airfield.addJets(fighterJet);
		System.out.println("Fighter Jet successfully added to fleet!");
	}

	private void removeJet() {
		System.out.print("Enter the number of the jet to remove: ");
		int jetIndex = sc.nextInt() - 1;

		if (jetIndex >= 0 && jetIndex < airfield.getJets().size()) {
			airfield.removeJetFromFleet(jetIndex);
			System.out.println("Jet successfully removed from the fleet.");
		} else {
			System.out.println("Invalid jet index. Please enter a valid number between 1 and "
					+ (airfield.getJets().size() + 1) + ".");
		}
	}
}
