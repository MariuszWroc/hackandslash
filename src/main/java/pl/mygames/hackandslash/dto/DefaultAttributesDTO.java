package pl.mygames.hackandslash.dto;

import java.io.Serializable;


public class DefaultAttributesDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private int minStrength;
    private int minDexterity;
    private int minIntelligence;
    private int minConstitution;
    private int minCharisma;
    private int maxStrength;
    private int maxDexterity;
    private int maxIntelligence;
    private int maxConstitution;
    private int maxCharisma;
    
    public DefaultAttributesDTO() {}
    
	public DefaultAttributesDTO(int minStrength, int minDexterity, int minIntelligence, int minConstitution,
			int minCharisma, int maxStrength, int maxDexterity, int maxIntelligence, int maxConstitution,
			int maxCharisma) {
		this.minStrength = minStrength;
		this.minDexterity = minDexterity;
		this.minIntelligence = minIntelligence;
		this.minConstitution = minConstitution;
		this.minCharisma = minCharisma;
		this.maxStrength = maxStrength;
		this.maxDexterity = maxDexterity;
		this.maxIntelligence = maxIntelligence;
		this.maxConstitution = maxConstitution;
		this.maxCharisma = maxCharisma;
	}
	
	public DefaultAttributesDTO(int minStrength, int minDexterity, int minIntelligence, int minConstitution,
			int minCharisma) {
		this.minStrength = minStrength;
		this.minDexterity = minDexterity;
		this.minIntelligence = minIntelligence;
		this.minConstitution = minConstitution;
		this.minCharisma = minCharisma;
	}
	
	public int getMinStrength() {
		return minStrength;
	}
	public void setMinStrength(int minStrength) {
		this.minStrength = minStrength;
	}
	public int getMinDexterity() {
		return minDexterity;
	}
	public void setMinDexterity(int minDexterity) {
		this.minDexterity = minDexterity;
	}
	public int getMinIntelligence() {
		return minIntelligence;
	}
	public void setMinIntelligence(int minIntelligence) {
		this.minIntelligence = minIntelligence;
	}
	public int getMinConstitution() {
		return minConstitution;
	}
	public void setMinConstitution(int minConstitution) {
		this.minConstitution = minConstitution;
	}
	public int getMinCharisma() {
		return minCharisma;
	}
	public void setMinCharisma(int minCharisma) {
		this.minCharisma = minCharisma;
	}
	public int getMaxStrength() {
		return maxStrength;
	}
	public void setMaxStrength(int maxStrength) {
		this.maxStrength = maxStrength;
	}
	public int getMaxDexterity() {
		return maxDexterity;
	}
	public void setMaxDexterity(int maxDexterity) {
		this.maxDexterity = maxDexterity;
	}
	public int getMaxIntelligence() {
		return maxIntelligence;
	}
	public void setMaxIntelligence(int maxIntelligence) {
		this.maxIntelligence = maxIntelligence;
	}
	public int getMaxConstitution() {
		return maxConstitution;
	}
	public void setMaxConstitution(int maxConstitution) {
		this.maxConstitution = maxConstitution;
	}
	public int getMaxCharisma() {
		return maxCharisma;
	}
	public void setMaxCharisma(int maxCharisma) {
		this.maxCharisma = maxCharisma;
	}
    
}
