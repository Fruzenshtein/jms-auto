package com.jms.util;

import java.util.Random;

public class RandonNumberGenerator {

	private static Random random = new Random();
	private static String randomNumber = String.valueOf(random.nextInt(999));

	public static String getRandomNumber() {
		return randomNumber;
	}

}
