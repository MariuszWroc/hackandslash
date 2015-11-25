package pl.mygames.hackandslash.controller.util;

public enum GuiEnums {
	MAX_ATTRIBUTE(18),
	MIN_ATTRIBUTE(3),
	VALUE_ATTRIBUTE(8);
	
	private final int attribute;
	
	private GuiEnums(int attribute) {
		this.attribute = attribute;
	}
	
	public int getAttribute() {
		return attribute;
	}
}
