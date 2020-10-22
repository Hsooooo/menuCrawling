package model;

public class NutritionModel {
	private String kcal;
	private String saturatedFat;
	private String protein;
	private String sugars;
	private String natrium;
	private String caffeine;
	
	public String getKcal() {
		return kcal;
	}
	public void setKcal(String kcal) {
		this.kcal = kcal;
	}
	public String getSaturatedFat() {
		return saturatedFat;
	}
	public void setSaturatedFat(String saturatedFat) {
		this.saturatedFat = saturatedFat;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getSugars() {
		return sugars;
	}
	public void setSugars(String sugars) {
		this.sugars = sugars;
	}
	public String getNatrium() {
		return natrium;
	}
	public void setNatrium(String natrium) {
		this.natrium = natrium;
	}
	
	
	public String getCaffeine() {
		return caffeine;
	}
	public void setCaffeine(String caffeine) {
		this.caffeine = caffeine;
	}
	@Override
	public String toString() {
		return "NutritionModel [kcal=" + kcal + ", saturatedFat=" + saturatedFat + ", protein=" + protein + ", sugars="
				+ sugars + ", natrium=" + natrium + ", caffeine=" + caffeine + "]";
	}
	
	
	
	
}
