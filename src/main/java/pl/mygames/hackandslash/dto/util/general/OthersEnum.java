package pl.mygames.hackandslash.dto.util.general;

public enum OthersEnum {
	POINTS(45);

	private final Integer points;
	
	private OthersEnum(Integer points) {
		this.points = points;
	}
	
	public Integer getPoints() {
		return points;
	}
}
