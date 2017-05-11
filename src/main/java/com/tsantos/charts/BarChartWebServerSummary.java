package com.tsantos.charts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import com.tsantos.template.Mysql;

public class BarChartWebServerSummary extends ApplicationFrame {

	private static long con_total = 0;
	private static long packets_total = 0;
	private static long packets_min = 0;
	private static long packets_avg = 0;
	private static long packets_max = 0;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	private static final long serialVersionUID = 1L;

	public BarChartWebServerSummary(String applicationTitle, String chartTitle, LocalDateTime startDateTime, LocalDateTime endDateTime) {
		super(applicationTitle);
		
		String timerange = startDateTime + " - " + endDateTime;
		
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "Packets Transmitted x Total Connections", "Amount Packets",
				createDataset(timerange), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private CategoryDataset createDataset(String timerange) {
		
try {
			
			con = Mysql.getConnection();
			
			// Port 80/443 9:00:00
			String query1 = "select " + "con_total, " + "packets_total, " + "packets_min, " + "packets_avg, " + "packets_max "
					+ "from webserversummary " + "where timerange = '"+timerange+"'";
			
			// create the java statement
			stmt = con.createStatement();

			// execute the query, and get a java resultset
			rs = stmt.executeQuery(query1);
			
			while (rs.next()) {
				con_total = rs.getLong("con_total");
				packets_total = rs.getLong("packets_total");
				packets_min = rs.getLong("packets_min");
				packets_avg = rs.getLong("packets_avg");
				packets_max = rs.getLong("packets_max");
			}

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		final String con_total1 = "Total Connections";
		final String sum_packets = "Sum";
		final String min_packets = "Min";
		final String avg_packets = "Avg";
		final String max_packets = "Max";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(con_total, con_total1, "");
		dataset.addValue(Math.sqrt(packets_total), sum_packets, "");
		dataset.addValue(Math.sqrt(packets_min), min_packets, "");
		dataset.addValue(Math.sqrt(packets_avg), avg_packets, "");
		dataset.addValue(Math.sqrt(packets_max), max_packets, "");

		return dataset;
	}

//	public static void main(String[] args) {
//		BarChartWebServerSummary chart = new BarChartWebServerSummary("Data Transmitted Statistics", "Data transmitted to servers - Summary");
//		chart.pack();
//		RefineryUtilities.centerFrameOnScreen(chart);
//		chart.setVisible(true);
//	}
}