package com.tsantos.command;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tsantos.hibernate.DestinationData;
import com.tsantos.hibernate.DestinationSummary;
import com.tsantos.hibernate.WebServerData;
import com.tsantos.hibernate.WebServerSummary;

public class CommandRequest {

	private static SessionFactory factory;
	static {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public Session getSession() {
		return factory.openSession();
	}

	public void RequestInsertDestinationData(String ip, Integer count, String timerange) {

		// Open connection
		Session session = getSession();
		session.beginTransaction();

		// Load DestinationData.class
		DestinationData dstdata = new DestinationData();
		dstdata.setIp(ip);
		dstdata.setBytes(count);
		dstdata.setTimerange(timerange);

		String hql = "update DestinationData " 
				+ "set ipaddress = :ipaddress, " 
				+ "bytes_received = :bytes_received "
				+ "where timerange = :timerange "
				+ "AND ipaddress = :ipaddress "
				+ "AND bytes_received = :bytes_received";

		Query query = session.createQuery(hql);
		query.setString("ipaddress", dstdata.getIp());
		query.setInteger("bytes_received", dstdata.getBytes());
		query.setString("timerange", dstdata.getTimerange());
		int rowCount = query.executeUpdate();

		if (rowCount == 0) {
			session.save(dstdata);
			session.getTransaction().commit();

		} else {
			session.flush();
			session.getTransaction().commit();
		}

		session.close();

	}

	public void RequestInsertDestinationSummary(long l, long m, int min, double avg, int max, String timerange) {

		Session session = getSession();
		session.beginTransaction();

		// Load DestinationSummary.class
		DestinationSummary dstsum = new DestinationSummary();
		dstsum.setCon_total(l);
		dstsum.setBytes_total(m);
		dstsum.setBytes_min(min);
		dstsum.setBytes_avg(avg);
		dstsum.setBytes_max(max);
		dstsum.setTimerange(timerange);

		String hql = "update DestinationSummary " 
				+ "set con_total = :con_total, " 
				+ "bytes_total = :bytes_total, "
				+ "bytes_min = :bytes_min, " 
				+ "bytes_avg = :bytes_avg, " 
				+ "bytes_max = :bytes_max "
				+ "where timerange = :timerange";

		Query query = session.createQuery(hql);
		query.setLong("con_total", dstsum.getCon_total());
		query.setLong("bytes_total", dstsum.getBytes_total());
		query.setInteger("bytes_min", dstsum.getBytes_min());
		query.setDouble("bytes_avg", dstsum.getBytes_avg());
		query.setInteger("bytes_max", dstsum.getBytes_max());
		query.setString("timerange", dstsum.getTimerange());
		int rowCount = query.executeUpdate();

		if (rowCount == 0) {
			session.save(dstsum);
			session.getTransaction().commit();

		} else {
			session.flush();
			session.getTransaction().commit();
		}

		session.close();

	}

	public void RequestInsertWebServerData(String dport, Integer count, String timerange) {

		// Open connection
		Session session = getSession();
		session.beginTransaction();

		// Load DestinationData.class
		WebServerData wsdata = new WebServerData();
		wsdata.setDport(dport);
		wsdata.setpackets(count);
		wsdata.setTimerange(timerange);

		String hql = "update WebServerData " 
					  + "set dport = :dport, " 
					  + "packets_received = :packets_received "
					  + "where timerange = :timerange "
					  + "and dport = :dport "
					  + "and packets_received = :packets_received";

		Query query = session.createQuery(hql);
		query.setString("dport", wsdata.getDport());
		query.setInteger("packets_received", wsdata.getpackets());
		query.setString("timerange", wsdata.getTimerange());
		int rowCount = query.executeUpdate();

		if (rowCount == 0) {
			session.save(wsdata);
			session.getTransaction().commit();

		} else {
			session.flush();
			session.getTransaction().commit();
		}
		session.close();

	}

	public void RequestInsertWebServerSummary(long l, long m, int min, double avg, int max, String timerange) {

		Session session = getSession();
		session.beginTransaction();

		// Load DestinationSummary.class
		WebServerSummary wssum = new WebServerSummary();
		wssum.setCon_total(l);
		wssum.setPackets_total(m);
		wssum.setPackets_min(min);
		wssum.setPackets_avg(avg);
		wssum.setPackets_max(max);
		wssum.setTimerange(timerange);

		String hql = "update WebServerSummary " + "set con_total = :con_total, " + "packets_total = :packets_total, "
				+ "packets_min = :packets_min, " + "packets_avg = :packets_avg, " + "packets_max = :packets_max "
				+ "where timerange = :timerange";

		Query query = session.createQuery(hql);
		query.setLong("con_total", wssum.getCon_total());
		query.setLong("packets_total", wssum.getPackets_total());
		query.setInteger("packets_min", wssum.getPackets_min());
		query.setDouble("packets_avg", wssum.getPackets_avg());
		query.setInteger("packets_max", wssum.getPackets_max());
		query.setString("timerange", wssum.getTimerange());
		int rowCount = query.executeUpdate();

		if (rowCount == 0) {
			session.save(wssum);
			session.getTransaction().commit();

		} else {
			session.flush();
			session.getTransaction().commit();
		}

		session.close();

	}

	// Call this during shutdown
	public static void close() {
		factory.close();
	}

}
