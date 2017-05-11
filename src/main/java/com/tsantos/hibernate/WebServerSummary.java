package com.tsantos.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBSERVERSUMMARY")
public class WebServerSummary {

	private Integer id;
	private Long con_total;
	private Long packets_total;
	private Integer packets_min;
	private Double packets_avg;
	private Integer packets_max;
	private String timerange;

	public WebServerSummary(Integer id, Long con_total, Long packets_total, Integer packets_min, Double packets_avg,
			Integer packets_max, String timerange) {
		this.id = id;
		this.con_total = con_total;
		this.packets_total = packets_total;
		this.packets_min = packets_min;
		this.packets_avg = packets_avg;
		this.packets_max = packets_max;
		this.timerange = timerange;
	}

	public WebServerSummary() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "CON_TOTAL")
	public Long getCon_total() {
		return con_total;
	}

	public void setCon_total(Long con_total) {
		this.con_total = con_total;
	}

	@Column(name = "PACKETS_TOTAL")
	public Long getPackets_total() {
		return packets_total;
	}

	public void setPackets_total(Long packets_total) {
		this.packets_total = packets_total;
	}

	@Column(name = "PACKETS_MIN")
	public Integer getPackets_min() {
		return packets_min;
	}

	public void setPackets_min(Integer packets_min) {
		this.packets_min = packets_min;
	}

	@Column(name = "PACKETS_AVG")
	public Double getPackets_avg() {
		return packets_avg;
	}

	public void setPackets_avg(Double packets_avg) {
		this.packets_avg = packets_avg;
	}

	@Column(name = "PACKETS_MAX")
	public Integer getPackets_max() {
		return packets_max;
	}

	public void setPackets_max(Integer packets_max) {
		this.packets_max = packets_max;
	}

	@Column(name = "TIMERANGE")
	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timeRange2) {
		this.timerange = timeRange2;
	}

}
