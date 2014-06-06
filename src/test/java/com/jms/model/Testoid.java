package com.jms.model;

public class Testoid {

	public static void main(String[] args) {
		
		Address a1 = new Address();
		a1.setZip("Fru");
		
		Address a2 = new Address();
		a2.setZip("Ololo");

		System.out.println(a1.equals(a2));
	}

}
