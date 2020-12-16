package com.meritamerica.assignment6.models;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		MeritBank.readFromFile("Bankinfo.txt");
		MeritBank.sortAccountHolders();
	}
}