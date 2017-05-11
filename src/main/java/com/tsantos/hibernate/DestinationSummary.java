package com.tsantos.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESTINATIONSUMMARY")
public class DestinationSummary {
	
	private Integer id;
	private Long con_total;
	private Long bytes_total;
	private Integer bytes_min;
	private Double bytes_avg;
	private Integer bytes_max;
	private String timerange;
	
	public DestinationSummary(Integer id, Long con_total, Long bytes_total, Integer bytes_min, Double bytes_avg,
			Integer bytes_max, String timerange) {
		this.id = id;
		this.con_total = con_total;
		this.bytes_total = bytes_total;
		this.bytes_min = bytes_min;
		this.bytes_avg = bytes_avg;
		this.bytes_max = bytes_max;
		this.timerange = timerange;
	}
	
	public DestinationSummary(){}
	
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
	@Column(name = "BYTES_TOTAL")
	public Long getBytes_total() {
		return bytes_total;
	}
	public void setBytes_total(Long bytes_total) {
		this.bytes_total = bytes_total;
	}
	@Column(name = "BYTES_MIN")
	public Integer getBytes_min() {
		return bytes_min;
	}
	public void setBytes_min(Integer bytes_min) {
		this.bytes_min = bytes_min;
	}
	@Column(name = "BYTES_AVG")
	public Double getBytes_avg() {
		return bytes_avg;
	}
	public void setBytes_avg(Double bytes_avg) {
		this.bytes_avg = bytes_avg;
	}
	@Column(name = "BYTES_MAX")
	public Integer getBytes_max() {
		return bytes_max;
	}
	public void setBytes_max(Integer bytes_max) {
		this.bytes_max = bytes_max;
	}
	
	@Column(name = "TIMERANGE")
	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timeRange2) {
		this.timerange = timeRange2;
	}

}
