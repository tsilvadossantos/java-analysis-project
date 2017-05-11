package com.tsantos.charts;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import com.tsantos.template.Mysql;

public class PieChartDestinationDataIpRange extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	static int row;
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	static DefaultPieDataset dataset = new DefaultPieDataset();

	public PieChartDestinationDataIpRange(String title) {
		super(title);
		setContentPane(createDemoPanel(null, null));
	}

	private static DefaultPieDataset createDataset(String timerange) {
		try {
			
			con = Mysql.getConnection();
			
			//top 10 hit servers
			String query1 = "SELECT bytes_received, ipaddress  "
					+ "FROM destinationdata  "
					+ "WHERE ipaddress BETWEEN '74.125.108.0' AND '74.125.108.254'  "
					+ "and timerange = '"+timerange+"'";
		
		
			// create the java statement
			stmt = con.createStatement();

			// execute the query, and get a java resultset
			rs = stmt.executeQuery(query1);
			
			
			
			while (rs.next()) {
				
				dataset.setValue(rs.getString("ipaddress"), rs.getLong("bytes_received"));
				
			}

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
	
		return dataset;

	}

	private static JFreeChart createChart(PieDataset dataset) {

		JFreeChart chart = ChartFactory.createPieChart("Data Received per Server - IP Range (Network)", // chart
																			// title
				dataset, // data
				true, // include legend
				true, false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.02);
		return chart;

	}

	public static JPanel createDemoPanel(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		String timerange = startDateTime + " - " + endDateTime;
		JFreeChart chart = createChart(createDataset(timerange));
		return new ChartPanel(chart);
	}
//
//	public static void main(String[] args) {
//
//		PieChartDestinationDataIpRange demo = new PieChartDestinationDataIpRange("Network Traffic Monitor");
//		demo.pack();
//		RefineryUtilities.centerFrameOnScreen(demo);
//		demo.setVisible(true);
//
//	}

}
