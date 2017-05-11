package com.tsantos.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SeedNetworkAnalysis {
	private BufferedReader reader;
	private List<StreamAPIModel> logList = new ArrayList<StreamAPIModel>();
	private String line;
	private String fileName;

	public SeedNetworkAnalysis() {
	}

	public SeedNetworkAnalysis(String fileName) {

		this.fileName = fileName;

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(String fileName) {
		this.fileName = fileName;
		try {
			this.reader = new BufferedReader(new FileReader(this.fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<StreamAPIModel> filterLogList(LocalDateTime startDate, LocalDateTime endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSSSSS");
		try {
			while ((line = this.reader.readLine()) != null) {

				LocalDateTime timeStamp = LocalDateTime.parse(line.split(",")[0], formatter);
				if (timeStamp.isAfter(startDate) && timeStamp.isBefore(endDate)) {
					
					StreamAPIModel data = new StreamAPIModel();
					data.setDestination(line.split(",")[6]);
					data.setDport((line.split(",")[7]));
					data.setTotalpackets(Integer.parseInt((line.split(",")[11])));
					data.setTotalbytes(Integer.parseInt((line.split(",")[12])));
										
					logList.add(new StreamAPIModel(data.getTotalbytes(), data.getDport(), 
							data.getTotalpackets(), data.getDestination()));
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logList;

	}

}
