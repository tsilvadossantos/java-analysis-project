package com.tsantos.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBSERVERDATA")
public class WebServerData {
	private long id;
	private String dport;
	private Integer packetsreceived;
	private String timerange;
	

	public WebServerData() {
	}
	
	public WebServerData(String dport) {
		this.dport = dport;

	}

	
	public WebServerData(long id, String dport, Integer packetsreceived) {
		super();
		this.id = id;
		this.dport = dport;
		this.packetsreceived = packetsreceived;
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "DPORT")
	public String getDport() {
		return dport;
	}

	public void setDport(String dport) {
		this.dport = dport;
	}

	@Column(name = "PACKETS_RECEIVED")
	public Integer getpackets() {
		return packetsreceived;
	}

	public void setpackets(Integer packetsreceived) {
		this.packetsreceived = packetsreceived;
	}
	
	@Column(name = "TIMERANGE")
	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timeRange2) {
		this.timerange = timeRange2;
	}



}
