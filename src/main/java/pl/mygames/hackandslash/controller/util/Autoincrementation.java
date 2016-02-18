package pl.mygames.hackandslash.controller.util;

public enum Autoincrementation {
	
	INSTANCE;

	public static Integer getValue(Integer actualValue) {
		if (actualValue != null) {
			return ++actualValue;
		} else {
			return actualValue = 1;
		}
	}
}
