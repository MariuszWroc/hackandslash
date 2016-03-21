package pl.mygames.hackandslash.util.constant;

public enum OthersEnum {
	SETTING_ATTRIBUTES_POINTS(45);

	private final Integer points;
	
	private OthersEnum(Integer points) {
		this.points = points;
	}
	
	public Integer getPoints() {
		return points;
	}
}
