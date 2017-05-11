package com.tsantos.mvc;

import java.util.IntSummaryStatistics;
import java.util.Map;

public class FeedMVCModel {

	public static DestinationModel feedDstByteCount(Map<String, Integer> bytesPerDestination,
			IntSummaryStatistics totalBytesSummary, String timeRange) {

		DestinationModel data = new DestinationModel();
		data.setBytesreceived(bytesPerDestination);
		data.setSummary(totalBytesSummary);
		data.setTimerange(timeRange);

		return data;

	}

	public static WebServerModel feedDportPacketCount(Map<String, Integer> packetsToDport,
			IntSummaryStatistics totalPacketsSummary, String timeRange) {

		WebServerModel data1 = new WebServerModel();
		data1.setPacketsreceived(packetsToDport);
		data1.setSummary(totalPacketsSummary);
		data1.setTimerange(timeRange);
		return data1;
	}

}
