/**
 * 
 */
package com.mssql.sqlserver.keystore;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;

/**
 * @author
 *
 */
public class Keystore {
	
    // The location of the keystore.
    private static String keyStoreLocation = "C:\\Dev\\Always Encrypted\\keystore.jks";

    // The password of the keystore and the key.
    private static char[] keyStoreSecret = "********".toCharArray();
    

	/**
	 * @param args
	 * 	 * 
	 */
	public static void main(String[] args) {	
		
		String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=<databaseName>;user=<user>;password=<password>;columnEncryptionSetting=Enabled;";
		
		 try (SQLServerConnection  connection = (SQLServerConnection) DriverManager.getConnection(connectionUrl)){
			 
			SQLServerColumnEncryptionKeyStoreProvider storeProvider = new CustomeSQLServerColumnEncryptionKeyStoreProvider(keyStoreLocation, keyStoreSecret);
			Map<String, SQLServerColumnEncryptionKeyStoreProvider> keyStoreMap = new HashMap<String, SQLServerColumnEncryptionKeyStoreProvider>();
			keyStoreMap.put(storeProvider.getName(), storeProvider);
			SQLServerConnection.registerColumnEncryptionKeyStoreProviders(keyStoreMap);	
		 
		 }catch (Exception e) {
	            e.printStackTrace();
	     }
		
	}

}
