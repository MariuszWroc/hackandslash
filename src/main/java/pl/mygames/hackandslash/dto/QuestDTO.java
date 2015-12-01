package pl.mygames.hackandslash.dto;

import java.io.Serializable;
import java.util.Date;

public class QuestDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String description;
    private String target;
    private Date startDate;
    private Integer passed;
    
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getPassed() {
		return passed;
	}
	public void setPassed(Integer passed) {
		this.passed = passed;
	}
    
}
