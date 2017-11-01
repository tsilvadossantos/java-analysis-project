package com.tsantos.charts;

public class MenuModel {
	
	private String startdate;
	private String endate;
	private String initialtime;
	private String finaltime;
	private String choice;
	
	public MenuModel(){}	
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String d1) {
		this.startdate = d1;
	}
	public String getEndate() {
		return endate;
	}
	public void setEndate(String date2) {
		this.endate = date2;
	}
	public String getInitialtime() {
		return initialtime;
	}
	public void setInitialtime(String initialtime) {
		this.initialtime = initialtime;
	}
	public String getFinaltime() {
		return finaltime;
	}
	public void setFinaltime(String finaltime) {
		this.finaltime = finaltime;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
	

}
