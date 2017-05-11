package com.tsantos.stream;

public class StreamAPIModel {
	
	private String timerange;
	private int totalbytes;
	private String destination;
	private int totalpackets;
	private String protocol;
	private String dport;
	
	
	public StreamAPIModel(int totalbytes, String dport, int totalpackets, String destination) {
		super();
		this.totalbytes = totalbytes;
		this.destination = destination;
		this.totalpackets = totalpackets;
		this.dport = dport;
		
	}

	public int getTotalpackets() {
		return totalpackets;
	}

	public void setTotalpackets(int totalpackets) {
		this.totalpackets = totalpackets;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getDport() {
		return dport;
	}

	public void setDport(String dport) {
		this.dport = dport;
	}

	public StreamAPIModel(){}

	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timerange) {
		this.timerange = timerange;
	}

	public Integer getTotalbytes() {
		return totalbytes;
	}

	public void setTotalbytes(Integer totalbytes) {
		this.totalbytes = totalbytes;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	

}
