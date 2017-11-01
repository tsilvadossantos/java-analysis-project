package com.tsantos.mvc;

import java.util.IntSummaryStatistics;
import java.util.Map;

public class DestinationController {

	private DestinationModel model;
	private DataView view;

	public DestinationController(DestinationModel model, DataView view) {

		this.model = model;
		this.view = view;
	}

	
	public void setBytesreceived(Map<String, Integer> ip) {
		model.setBytesreceived(ip);
	}

	public Map<String, Integer> getdest() {
		return model.getBytesreceived();
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
	

	public void updateViewDstData() {

		view.printDstData(model.getBytesreceived(), model.getSummary(), model.getTimerange());

	}
	

}
