package com.tsantos.stream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToDateTime {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSSSSS");

	public StringToDateTime() {
	}

	public StringToDateTime(LocalDateTime startDate, LocalDateTime endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(String date1) {
		this.startDate = LocalDateTime.parse(date1 + ".000000", formatter);

	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(String date2) {
		this.endDate = LocalDateTime.parse(date2+ ".000000", formatter);
	}

}
