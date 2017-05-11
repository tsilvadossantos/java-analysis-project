package com.tsantos.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESTINATIONDATA")
public class DestinationData {
	private long id;
	private String ipaddress;
	private Integer bytesreceived;
	private String timerange;
	

	public DestinationData() {
	}
	
	public DestinationData(String ipaddress) {
		this.ipaddress = ipaddress;

	}

	
	public DestinationData(long id, String ipaddress, Integer bytesreceived, String timerange) {
		super();
		this.id = id;
		this.ipaddress = ipaddress;
		this.bytesreceived = bytesreceived;
		this.timerange = timerange;
		
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

	@Column(name = "IPADDRESS")
	public String getIp() {
		return ipaddress;
	}

	public void setIp(String ip) {
		this.ipaddress = ip;
	}

	@Column(name = "BYTES_RECEIVED")
	public Integer getBytes() {
		return bytesreceived;
	}

	public void setBytes(Integer bytesreceived) {
		this.bytesreceived = bytesreceived;
	}
	
	@Column(name = "TIMERANGE")
	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timeRange2) {
		this.timerange = timeRange2;
	}



}
