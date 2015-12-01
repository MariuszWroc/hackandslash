package pl.mygames.hackandslash.service.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RandomValue {
    private static final Logger logger = LoggerFactory.getLogger(RandomValue.class);
	
	public static int randomInteger(int start, int end) {
		Random random = new Random();
		
		if (start > end) {
			logger.info("Wrong parameters. Start value is higher then end value.");
		}
		long range = (long) end - (long) start + 1;
		long fraction = (long) (range * random.nextDouble());
		int randomNumber = (int) (fraction + start);
		
		return randomNumber;
	}
}
