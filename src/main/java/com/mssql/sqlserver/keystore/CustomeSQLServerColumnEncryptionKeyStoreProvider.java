package com.mssql.sqlserver.keystore;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.sql.SQLException;
import java.text.MessageFormat;

import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class CustomeSQLServerColumnEncryptionKeyStoreProvider extends SQLServerColumnEncryptionKeyStoreProvider{
	
	static final private java.util.logging.Logger customeCertificateStoreLogger = java.util.logging.Logger
            .getLogger("com.mssql.sqlserver.keystore.CustomeSQLServerColumnEncryptionKeyStoreProvider");
	
	// String name = "MSSQL_CERTIFICATE_STORE";
	 
	 String name = "CUSTOM_KEYSTORE";
	 String keyStorePath = null;
	 char[] keyStorePwd = null;
	 
    /**
     * Constructs a SQLServerColumnEncryptionCertificateStoreProvider.
     * @throws KeyStoreException 
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws CertificateException 
     * @throws NoSuchAlgorithmException 
     */
    public CustomeSQLServerColumnEncryptionKeyStoreProvider(String keyStoreLocation,char[] keyStoreSecret) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException  {
    	customeCertificateStoreLogger.entering(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "CustomeSQLServerColumnEncryptionKeyStoreProvider");

    	if ((null == keyStoreLocation) || (0 == keyStoreLocation.length())) {
             throw new KeyStoreException("Invalid Keystore");
    	 }
    	 
    	KeyStore ks = KeyStore.getInstance("JKS");
 		ks.load(new FileInputStream(keyStoreLocation), keyStoreSecret);
 			
 		this.keyStorePath = keyStoreLocation;
 		
 		 if (customeCertificateStoreLogger.isLoggable(java.util.logging.Level.FINE)) {
 			customeCertificateStoreLogger.fine("Path of key store provider is set.");
         }

         // Password can be null or empty, PKCS12 type allows that.
         if (null == keyStoreSecret) {
             keyStoreSecret = "".toCharArray();
         }
         
         this.keyStorePwd = new char[keyStoreSecret.length];
         System.arraycopy(keyStoreSecret, 0, this.keyStorePwd, 0, keyStoreSecret.length);

         if (customeCertificateStoreLogger.isLoggable(java.util.logging.Level.FINE)) {
        	 customeCertificateStoreLogger.fine("Password for key store provider is set.");
         }
    	
    }

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	

	public byte[] decryptColumnEncryptionKey(String masterKeyPath, String encryptionAlgorithm,
			byte[] encryptedColumnEncryptionKey) throws SQLServerException {
		customeCertificateStoreLogger.entering(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "decryptColumnEncryptionKey", "Decrypting Column Encryption Key.");
		
		
		byte[] plainCEK = null;    
		
		

		
		customeCertificateStoreLogger.exiting(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "decryptColumnEncryptionKey", "Finished decrypting Column Encryption Key.");
		return plainCEK;
	}

	@Override
	public byte[] encryptColumnEncryptionKey(String masterKeyPath, String encryptionAlgorithm,
			byte[] plainTextColumnEncryptionKey) throws SQLServerException {
		customeCertificateStoreLogger.entering(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "EncryptColumnEncryptionKey","Encrypting Column Encryption Key.");

		if (null == masterKeyPath || masterKeyPath.trim().length() == 0) {
	            System.out.println("R_InvalidMasterKeyDetails");
	      }
		
			
		
		 
		
		customeCertificateStoreLogger.exiting(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
	                "EncryptColumnEncryptionKey","Encrypting Column Encryption Key.");

		return null;
	}

	@Override
	public boolean verifyColumnMasterKeyMetadata(String masterKeyPath, boolean allowEnclaveComputations,
			byte[] signature) throws SQLServerException {
		// TODO Auto-generated method stub
		return false;
	}

}
