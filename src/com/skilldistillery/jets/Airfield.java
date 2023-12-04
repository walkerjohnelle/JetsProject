package com.skilldistillery.jets;

import java.util.ArrayList;

public class Airfield {
	private ArrayList<Jet> jets;

	public Airfield() {
		this.jets = new ArrayList<>();
	}

	public void addJets(Jet jet) {
		jets.add(jet);
	}

	public ArrayList<Jet> getJets() {
		return jets;
	}

	public Jet[] getFleet() {
		return jets.toArray(new Jet[0]);
	}

	public Jet getFastestJet() {
		if (jets.isEmpty()) {
			return null;
		}

		Jet fastestJet = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getSpeedInMph() > fastestJet.getSpeedInMph()) {
				fastestJet = jet;
			}
		}
		return fastestJet;
	}

	public Jet getLongestRangeJet() {
		if (jets.isEmpty()) {
			return null;
		}

		Jet longestRangeJet = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > longestRangeJet.getRange()) {
				longestRangeJet = jet;
			}
		}
		return longestRangeJet;
	}

	public void removeJetFromFleet(int index) {
		if (index >= 0 && index < jets.size()) {
			jets.remove(index);
		}
	}
}
