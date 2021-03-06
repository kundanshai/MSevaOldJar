
package com.djb.wipro.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.SystemException;


public class DBConnector {

	private static final Hashtable<String, String> envParams = new Hashtable<String, String>();
	private static final String wbl_factory = "weblogic.jndi.WLInitialContextFactory";
	static {
		envParams.put(Context.INITIAL_CONTEXT_FACTORY, wbl_factory);
		envParams.put(Context.PROVIDER_URL, PropertyUtil
				.getProperty("JNDI_PROVIDER"));
	}

	/**
	 * <p>
	 * Create database connection. The <code>getConnection</code> method creates
	 * Database Connection to perform various database related operations.
	 * </p>
	 * 
	 * @return
	 * @throws SystemException
	 * @throws IOException
	 */
	public static Connection getConnection() throws SystemException,
			IOException {
		AppLog.begin();
		Connection connection = null;
		Context context = null;
		String dataSourceReferenceName = null;
		DataSource ds = null;
		try {
			context = new InitialContext(envParams);
			dataSourceReferenceName = PropertyUtil.getProperty("JNDI_DS");
			ds = (DataSource) context.lookup(dataSourceReferenceName);
			connection = ds.getConnection();

		} catch (NamingException e) {
			AppLog.error(e);
		} catch (SQLException e) {
			AppLog.error(e);
		} catch (Exception e) {
			AppLog.error(e);
		}
		AppLog.end();
		return connection;
	}

	/**
	 * <p>
	 * Create database connection. The <code>getConnection</code> method creates
	 * Database Connection to perform various database related operations with
	 * two parameter data source name and JNDI Provider URL.
	 * </p>
	 * 
	 * @author Rajib Hazarika(Tata Consultancy Services)
	 * @since 28-JAN-2016
	 * 
	 * @param dataSourceName
	 *            JNDI Data Source Name
	 * @param providerURL
	 *            JNDI Provider URL
	 * @return connection is the database connection
	 * @throws IOException
	 * @see Connection
	 * @see Context
	 * @see DataSource
	 * @see InitialContext
	 */
	public static Connection getConnection(String dataSourceName,
			String providerURL) throws IOException {
		AppLog.begin();
		Connection connection = null;
		Context context = null;
		DataSource ds = null;
		Hashtable<String, String> contextParams = null;
		try {
			contextParams = new Hashtable<String, String>();
			contextParams.put(Context.INITIAL_CONTEXT_FACTORY, wbl_factory);
			contextParams.put(Context.PROVIDER_URL, providerURL.trim());
			context = new InitialContext(contextParams);
			ds = (DataSource) context.lookup(dataSourceName.trim());
			connection = ds.getConnection();
		} catch (NamingException e) {
			AppLog.error(e);
		} catch (SQLException e) {
			AppLog.error(e);
		} catch (Exception e) {
			AppLog.error(e);
		}
		AppLog.end();
		return connection;
	}
	
	public static void closeConnection(Connection conn, PreparedStatement ps,ResultSet rs)
			throws IOException {
		AppLog.begin();
		try {
			if (null != conn) {
				conn.close();
				AppLog.info("Connection Closed");
			}
		} catch (Exception e) {
			// ignore;
		}
		try {
			if (null != ps) {
				ps.close();
				AppLog.info("Statment Closed");
			}
		} catch (Exception e) {
			// ignore;
		}
		AppLog.end();
	}
}
