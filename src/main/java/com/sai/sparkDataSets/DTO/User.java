
/**
 * @author Saikistnah
 *
 */
package com.sai.sparkDataSets.DTO;

public class User{
	private String name;
	private Boolean lovesPandas;
	private KnowDTO knows;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getLovesPandas() {
		return lovesPandas;
	}
	public void setLovesPandas(Boolean lovesPandas) {
		this.lovesPandas = lovesPandas;
	}
	public KnowDTO getKnows() {
		return knows;
	}
	public void setKnows(KnowDTO knows) {
		this.knows = knows;
	}
	
}