package pl.mygames.hackandslash.controller.util;

public class Autoincrementation {
	
	public Autoincrementation() {
	}

	public static Integer getValue(Integer actualValue) {
		if (actualValue != null) {
			return ++actualValue;
		} else {
			return actualValue = 1;
		}
	}

}
