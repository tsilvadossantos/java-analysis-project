package com.tsantos.mvc;

import java.util.IntSummaryStatistics;
import java.util.Map;

public class WebServerModel {
	
	private Map<String, Integer> packetsreceived;
	private IntSummaryStatistics summary;
	private String timerange;
	
	
	public WebServerModel(){}


	public WebServerModel(Map<String, Integer> packetsreceived, IntSummaryStatistics summary, String timerange) {
		super();
		this.packetsreceived = packetsreceived;
		this.summary = summary;
		this.timerange = timerange;
	}


	public Map<String, Integer> getPacketsreceived() {
		return packetsreceived;
	}


	public void setPacketsreceived(Map<String, Integer> packetsreceived) {
		this.packetsreceived = packetsreceived;
	}


	public IntSummaryStatistics getSummary() {
		return summary;
	}


	public void setSummary(IntSummaryStatistics summary) {
		this.summary = summary;
	}


	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timeRange2) {
		this.timerange = timeRange2;
	}
	
	
	
	

}
