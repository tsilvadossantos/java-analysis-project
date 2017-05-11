package com.tsantos.mvc;

import java.util.IntSummaryStatistics;
import java.util.Map;

public class DestinationModel {
	
	private Map<String, Integer> bytesreceived;
	private IntSummaryStatistics summary;
	private String timerange;
	
	public DestinationModel(Map<String, Integer> bytesreceived, IntSummaryStatistics summary) {
		this.bytesreceived = bytesreceived;
		this.summary = summary;
	}	
	
	public DestinationModel(){}
	
	public Map<String, Integer> getBytesreceived() {
		return bytesreceived;
	}
	public void setBytesreceived(Map<String, Integer> bytesreceived) {
		this.bytesreceived = bytesreceived;
	}
	public IntSummaryStatistics getSummary() {
		return summary;
	}
	public void setSummary(IntSummaryStatistics totalBytesSummary) {
		this.summary = totalBytesSummary;
	}

	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timeRange2) {
		this.timerange = timeRange2;
	}
	
	
	
	
}
