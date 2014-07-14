package com.jms.util;

import java.util.UUID;

public class RandonUUIDGenerator {

	private static UUID random = UUID.randomUUID();
	private static String randomNumber = String.valueOf(random);

	public static String getRandomNumber() {
		return randomNumber;
	}

}
