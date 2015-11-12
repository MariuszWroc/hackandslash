package pl.mygames.hackandslash.service.util;

public class Autoincrementation {
	
	public Autoincrementation() {
	}

	public static Integer getValue(Integer actualValue) {
		if (actualValue != null) {
			return actualValue++;
		} else {
			return actualValue = 1;
		}
	}

}
