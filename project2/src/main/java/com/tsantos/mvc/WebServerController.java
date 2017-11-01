package com.tsantos.mvc;

import java.util.IntSummaryStatistics;
import java.util.Map;

public class WebServerController {
	

	private WebServerModel model;
	private DataView view;

	public WebServerController(WebServerModel model, DataView view) {

		this.model = model;
		this.view = view;
	}

	
	public void setPacketsreceived(Map<String, Integer> ip) {
		model.setPacketsreceived(ip);
	}

	public Map<String, Integer> getdest() {
		return model.getPacketsreceived();
	}
	
	public void setSummary(IntSummaryStatistics summ) {
		model.setSummary(summ);
	}

	public IntSummaryStatistics getSummary() {
		return model.getSummary();
	}
	
	public void setTimerange(String time) {
		model.setTimerange(time);
	}

	public String getTimerange() {
		return model.getTimerange();
	}
	

	public void updateViewDportData() {

		view.printDportData(model.getPacketsreceived(), model.getSummary(), model.getTimerange());

	}


}
