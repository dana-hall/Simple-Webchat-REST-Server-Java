package org.danahall.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

@SuppressWarnings("deprecation")
public class MongoFactory {

	private static MongoClient mongo;
	private static int port_no;
	private static String hostname;
	private static String database;
	private static String document;

	private MongoFactory() {
	}

	// Returns a mongo instance.
	private static MongoClient getMongo() {

		if (mongo == null) {
			// Get MongoDB Connection info from properties file
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("mongodb.properties");
			Properties mongoConn = new Properties();
			try {
				mongoConn.load(input);

				// Set connection properties
				port_no = Integer.parseInt(mongoConn.getProperty("port"));
				hostname = mongoConn.getProperty("hostname");
				database = mongoConn.getProperty("database");
				document = mongoConn.getProperty("document");

				mongo = new MongoClient(hostname, port_no);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (MongoException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return mongo;
	}

	// Fetches the collection from the mongo database.
	public static DBCollection getCollection() {
		return getMongo().getDB(database).getCollection(document);
	}
}
